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

package com.destin.moeviewer.provider;

import com.destin.moeviewer.data.Provider;
import com.destin.moeviewer.model.common.Post;
import com.destin.moeviewer.model.common.Tag;
import com.destin.moeviewer.network.LogInterceptor;
import com.destin.moeviewer.network.MoeApi;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

public class YandeProvider implements Provider {
    private static YandeProvider sProvider;
    private MoeApi mMoeApi;

    private YandeProvider() {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new LogInterceptor()).build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("https://yande.re/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mMoeApi = retrofit.create(MoeApi.class);
    }

    public static YandeProvider getInstance() {
        if (sProvider == null)
            sProvider = new YandeProvider();
        return sProvider;
    }

    private final Func1<String, Observable<String[]>> autoCompleteFunc = new Func1<String, Observable<String[]>>() {
        @Override
        public Observable<String[]> call(String s) {
            return mMoeApi.listTags(8, null, MoeApi.COUNT, null, null, s, null).map(tagsToArray);
        }
    };


    private final Func1<Integer, Observable<List<Post>>> postFunc = new Func1<Integer, Observable<List<Post>>>() {
        @Override
        public Observable<List<Post>> call(Integer integer) {

            return mMoeApi.listPosts(POST_LIMIT, integer, null);
        }
    };


    private final Func1<List<Tag>, String[]> tagsToArray = new Func1<List<Tag>, String[]>() {
        @Override
        public String[] call(List<Tag> tags) {
            String[] array = new String[tags.size()];
            for (int i = 0; i < array.length; i++)
                array[i] = tags.get(i).getName();
            return array;
        }
    };


    @Override
    public Func1<String, Observable<String[]>> getAutoCompleteFunc() {
        return autoCompleteFunc;
    }

    @Override
    public Func1<Integer, Observable<List<Post>>> getPostFunc() {
        return postFunc;
    }
}
