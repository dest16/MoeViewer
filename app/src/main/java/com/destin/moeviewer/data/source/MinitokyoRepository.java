package com.destin.moeviewer.data.source;

import android.util.Log;

import com.destin.moeviewer.data.Post;
import com.destin.moeviewer.model.minitokyo.MiniTokyoPost;
import com.destin.moeviewer.network.MinitokyoApi;
import com.destin.moeviewer.util.MoeClient;
import com.destin.sehaikun.StringUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.functions.Func1;

public class MinitokyoRepository implements MoeDataSource {
    private final String URL = "http://www.minitokyo.net/";
    private static MinitokyoRepository sRepository;
    private MinitokyoApi mMinitokyoApi;
    private Map<String, String> ids = new HashMap<>();

    private MinitokyoRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(MoeClient.getClient())
                .baseUrl(URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        mMinitokyoApi = retrofit.create(MinitokyoApi.class);
    }

    public static MinitokyoRepository getInstance() {
        if (sRepository == null)
            sRepository = new MinitokyoRepository();
        return sRepository;
    }

    private final Func1<String, List<MiniTokyoPost>> toMinitokyoPostFunc = s -> {
        Document doc = Jsoup.parse(s);
        Element root = doc.select("ul.scans").first();
        if (root == null)
            return new ArrayList<>(0);
        Elements elements = root.select("li");
        List<MiniTokyoPost> posts = new ArrayList<>(elements.size());
        for (Element element : elements) {
            MiniTokyoPost post = new MiniTokyoPost();
            Element a = element.select("a").first();
            Element img = a.select("img").first();
            String href = a.attr("href");
            post.setId(Integer.parseInt(href.substring(href.lastIndexOf("/") + 1)));
            post.setPreviewUrl(img.attr("src").replace("static3", "static"));
            post.setSeries(img.attr("alt"));
            String[] info = img.attr("title").split("x");
            post.setRawWidth(Integer.parseInt(info[0]));
            post.setRawHeight(Integer.parseInt(info[1]));
            posts.add(post);
        }
        Log.i("MiniTokyoPost", posts.size() + "");
        return posts;
    };

    private final Func1<List<MiniTokyoPost>, List<Post>> toPostFunc = miniTokyoPosts -> {
        List<Post> list = new ArrayList<>(miniTokyoPosts.size());
        for (MiniTokyoPost post : miniTokyoPosts) {
            Post temp = new Post();
            temp.setRatio((float) post.getRawHeight() / post.getRawWidth());
            temp.setPreUrl(post.getPreviewUrl());
            temp.setSampleUrl(post.getPreviewUrl().replace("thumbs", "view"));
            temp.setRawUrl(post.getPreviewUrl().replace("thumbs", "downloads"));
//                temp.setTagArray(StringUtils.split(post.getTags(), "\b"));
//                temp.setSource(post.getSource());
            temp.setDesc("minitokyo.net");
            list.add(temp);
        }
        Log.i("Post", list.size() + "");
        return list;
    };
    private final Func1<String, String[]> toTagArray = s -> {
        if (StringUtils.isEmpty(s))
            return StringUtils.EMPTY_ARRAY;
        String[] array = s.split("\n");
        for (int i = 0; i < array.length; i++)
            array[i] = array[i].split("\\|")[0];
        return array;
    };

    String getTid(String tag, String s) {
        String tid = s.substring(s.indexOf("tid=") + 4, s.indexOf("&"));
        ids.put(tag, tid);
        return tid;
    }

    @Override
    public Observable<List<Post>> getRecentPosts(int page) {
        return mMinitokyoApi.listPosts(null, null, page + 1).map(toMinitokyoPostFunc).map(toPostFunc);
    }

    @Override
    public Observable<List<Post>> getSearchPosts(int page, String tag) {
        return Observable.just(ids.containsKey(tag)).map(aBoolean -> {
            try {
                return aBoolean ? ids.get(tag) : getTid(tag, Jsoup.connect(URL + tag).get().getElementById("tabs").select("li a[href]").get(1).attr("href"));
            } catch (IOException e) {
                return null;
            }
        }).flatMap(s -> mMinitokyoApi.showPosts(s, "id", page + 1)).map(toMinitokyoPostFunc).map(toPostFunc);
    }

    @Override
    public Observable<String[]> getSuggestions(String tag) {
        return mMinitokyoApi.autoTags(tag).map(toTagArray);
    }
}
