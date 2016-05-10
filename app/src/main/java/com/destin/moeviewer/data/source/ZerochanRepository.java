/*
 * Copyright (C) 2016 dest16
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.destin.moeviewer.data.source;

import com.destin.moeviewer.data.Post;
import com.destin.moeviewer.model.zerochan.ZeroChanPost;
import com.destin.moeviewer.network.ZeroChanApi;
import com.destin.moeviewer.util.MoeClient;
import com.destin.sehaikun.StringUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import rx.Observable;
import rx.functions.Func1;


public class ZerochanRepository implements MoeDataSource {
    private static final String URL = "http://www.zerochan.net/";
    private static final int POST_LIMIT = 20;
    private static ZerochanRepository sRepository;
    private ZeroChanApi mZeroChanApi;


    private ZerochanRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(MoeClient.getClient())
                .baseUrl(URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        mZeroChanApi = retrofit.create(ZeroChanApi.class);

    }

    public static ZerochanRepository getInstance() {
        if (sRepository == null)
            sRepository = new ZerochanRepository();
        return sRepository;
    }

    private final Func1<String, List<ZeroChanPost>> toBooruPostFunc = s -> {
        Document doc = Jsoup.parse(s);
        Element root = doc.getElementById("thumbs2");
        if (root == null)
            return new ArrayList<>(0);
        Elements elements = root.select("li");
        List<ZeroChanPost> posts = new ArrayList<>(elements.size());
        for (Element element : elements) {
            ZeroChanPost post = new ZeroChanPost();
            Element a = element.select("a").first();
            Element img = element.select("a img").first();
            post.setId(Integer.parseInt(a.attr("href").replaceAll("[^0-9]", "")));
            post.setPreviewUrl(img.attr("src"));
            post.setSeries(img.attr("alt"));
            String[] info = img.attr("title").split("[x ]");
            post.setWidth(Integer.parseInt(info[0]));
            post.setHeight(Integer.parseInt(info[1]));
            posts.add(post);
        }
        return posts;
    };

    private final Func1<List<ZeroChanPost>, List<Post>> toPostFunc = zeroChanPosts -> {
        List<Post> list = new ArrayList<>(zeroChanPosts.size());
        for (ZeroChanPost post : zeroChanPosts) {
            Post temp = new Post();
            temp.setRatio((float) post.getHeight() / post.getWidth());
            temp.setPreUrl(post.getPreviewUrl());
            temp.setSampleUrl(post.getPreviewUrl().replace(".240.", ".600."));
            temp.setRawUrl(post.getPreviewUrl().replace(".240.", ".full."));
//                temp.setTagArray(StringUtils.split(post.getTags(), "\b"));
//                temp.setSource(post.getSource());
            temp.setDesc("zerochan.net");
            list.add(temp);
        }
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

    @Override
    public Observable<List<Post>> getRecentPosts(int page) {
        return mZeroChanApi.listPosts(null, page + 1).map(toBooruPostFunc).map(toPostFunc);
    }

    @Override
    public Observable<List<Post>> getSearchPosts(int page, String tag) {
        return mZeroChanApi.search(tag, page + 1).map(toBooruPostFunc).map(toPostFunc);
    }

    @Override
    public Observable<String[]> getSuggestions(String tag) {
        return mZeroChanApi.autoTags(tag).map(toTagArray);
    }
}
