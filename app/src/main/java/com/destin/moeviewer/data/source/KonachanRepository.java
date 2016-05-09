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
import com.destin.moeviewer.model.common.MoePost;
import com.destin.moeviewer.model.common.MoeTag;
import com.destin.moeviewer.network.MoeApi;
import com.destin.moeviewer.util.MoeClient;
import com.destin.sehaikun.StringUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

public class KonachanRepository implements MoeDataSource {
    private static final int POST_LIMIT = 20;
    private static KonachanRepository sProvider;
    private MoeApi mMoeApi;

    private KonachanRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(MoeClient.getClient())
                .baseUrl("http://konachan.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mMoeApi = retrofit.create(MoeApi.class);
    }

    public static KonachanRepository getInstance() {
        if (sProvider == null)
            sProvider = new KonachanRepository();
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

    private final Func1<List<MoePost>, List<Post>> toPostFunc = new Func1<List<MoePost>, List<Post>>() {
        @Override
        public List<Post> call(List<MoePost> moePosts) {
            List<Post> list = new ArrayList<>(moePosts.size());
            for (MoePost post : moePosts) {
                Post temp = new Post();
                temp.setRatio((float) post.getPreviewHeight() / post.getPreviewWidth());
                temp.setPreUrl(post.getPreviewUrl());
                temp.setSampleUrl(post.getSampleUrl());
                temp.setRawUrl(post.getFileUrl());
                temp.setTagArray(StringUtils.split(post.getTags(), "\b"));
                temp.setSource(post.getSource());
                temp.setDesc("konachan.com");
                list.add(temp);
            }
            return list;
        }
    };


    @Override
    public Observable<List<Post>> getRecentPosts(int page) {
        return mMoeApi.listPosts(POST_LIMIT, page + 1, null).map(toPostFunc);
    }

    @Override
    public Observable<List<Post>> getSearchPosts(int page, String tag) {
        return mMoeApi.listPosts(POST_LIMIT, page + 1, StringUtils.encode(tag)).map(toPostFunc);
    }

    @Override
    public Observable<String[]> getSuggestions(String tag) {
        return mMoeApi.listTags(8, null, MoeApi.COUNT, null, null, tag + "*", null).map(tagsToArray);
    }

}
