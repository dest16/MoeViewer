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
import com.destin.moeviewer.network.BooruApi;
import com.destin.moeviewer.util.MoeClient;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import rx.Observable;

public class SafebooruRepository implements MoeDataSource {
    private static final String URL = "http://safebooru.org/";
    private static SafebooruRepository sRepository;
    private BooruApi mBooruApi;

    public SafebooruRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(MoeClient.getClient())
                .baseUrl(URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
        mBooruApi = retrofit.create(BooruApi.class);
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
