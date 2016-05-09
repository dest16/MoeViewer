package com.destin.moeviewer.data.source;

import com.destin.moeviewer.data.Post;
import com.destin.moeviewer.network.ZeroChanApi;
import com.destin.moeviewer.util.MoeClient;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by dest16 on 2016/5/9.
 */
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
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mZeroChanApi = retrofit.create(ZeroChanApi.class);

    }


    @Override
    public Observable<List<Post>> getRecentPosts(int page) {
        return null;
    }

    @Override
    public Observable<List<Post>> getSearchPosts(int page, String tag) {
        return null;
    }

    @Override
    public Observable<String[]> getSuggestions(String tag) {
        return null;
    }
}
