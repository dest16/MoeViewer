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

import com.destin.moeviewer.model.common.MoePost;
import com.destin.moeviewer.model.common.MoeTag;
import com.destin.moeviewer.network.LogInterceptor;
import com.destin.moeviewer.network.MoeApi;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

public class YandeRepository implements MoeDataSource {
    private static final int POST_LIMIT = 20;
    private static YandeRepository sProvider;
    private MoeApi mMoeApi;

    private YandeRepository() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new LogInterceptor()).build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://yande.re/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mMoeApi = retrofit.create(MoeApi.class);
    }

    public static YandeRepository getInstance() {
        if (sProvider == null)
            sProvider = new YandeRepository();
        return sProvider;
    }


    private final Func1<List<MoeTag>, String[]> tagsToArray = new Func1<List<MoeTag>, String[]>() {
        @Override
        public String[] call(List<MoeTag> tags) {
            String[] array = new String[tags.size()];
            for (int i = 0; i < array.length; i++)
                array[i] = tags.get(i).getName();
            return array;
        }
    };

    @Override
    public Observable<List<MoePost>> getRecentPosts(int page) {
        return mMoeApi.listPosts(POST_LIMIT, page + 1, null);
    }

    @Override
    public Observable<List<MoePost>> getSearchPosts(int page, String tag) {
        return mMoeApi.listPosts(POST_LIMIT, page + 1, tag);
    }

    @Override
    public Observable<String[]> getSuggestions(String tag) {
        return mMoeApi.listTags(8, null, MoeApi.COUNT, null, null, tag + "*", null).map(tagsToArray);
    }

}
