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
import com.destin.moeviewer.model.shuushuu.ShuushuuPost;
import com.destin.moeviewer.model.shuushuu.ShuushuuResult;
import com.destin.moeviewer.network.ShuushuuApi;
import com.destin.moeviewer.util.MoeClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

public class ShuushuuRepository implements MoeDataSource {
    private static final String URL = "http://e-shuushuu.net/";
    private static final String pre_format = "images/thumbs/%s.jpeg";
    private static final String raw_format = "images/%s.%s";
    private static final int POST_LIMIT = 20;
    private static ShuushuuRepository sRepository;
    private ShuushuuApi mShuushuuApi;

    private ShuushuuRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(MoeClient.getClient())
                .baseUrl(URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mShuushuuApi = retrofit.create(ShuushuuApi.class);
    }

    private final Func1<ShuushuuResult, List<Post>> toPostFun = shuushuuResult -> {
        List<ShuushuuPost> shuuList = shuushuuResult.getImages();
        List<Post> list = new ArrayList<>(shuuList.size());
        for (ShuushuuPost post : shuuList) {
            Post temp = new Post();
            temp.setRatio((long) post.getThumbHeight() / post.getThumbWidth());
            temp.setPreUrl(String.format(pre_format, post.getFilename()));
            temp.setSampleUrl(temp.getPreUrl());
            temp.setRawUrl(String.format(raw_format, post.getFilename(), post.getExt()));
//                    temp.setTagArray();
//                    temp.setSource();
            temp.setDesc("e-shuushuu.net");
            list.add(temp);
        }
        return list;
    };

    @Override
    public Observable<List<Post>> getRecentPosts(int page) {
        return mShuushuuApi.listPosts(page + 1, null).map(toPostFun);
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
