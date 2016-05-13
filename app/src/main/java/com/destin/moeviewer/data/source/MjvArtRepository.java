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
import com.destin.moeviewer.model.mjvart.MjvArtList;
import com.destin.moeviewer.model.mjvart.MjvArtPost;
import com.destin.moeviewer.network.MjvArtApi;
import com.destin.moeviewer.util.MoeClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

public class MjvArtRepository implements MoeDataSource {
    private static final String URL = "https://anime-pictures.net/";
    private static final int POST_LIMIT = 20;
    private static MjvArtRepository sRepository;
    private MjvArtApi mMjvArtApi;

    private MjvArtRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(MoeClient.getClient())
                .baseUrl(URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mMjvArtApi = retrofit.create(MjvArtApi.class);
    }

    public static MjvArtRepository getInstance() {
        if (sRepository == null)
            sRepository = new MjvArtRepository();
        return sRepository;
    }

    @Override
    public Observable<List<Post>> getRecentPosts(int page) {
        return mMjvArtApi.listPosts(page, POST_LIMIT, null, null, null, null, null, null, null).map(new Func1<MjvArtList, List<Post>>() {
            @Override
            public List<Post> call(MjvArtList mjvArtList) {
                List<MjvArtPost> mjvArtPosts = mjvArtList.getPosts();
                List<Post> list = new ArrayList<>(mjvArtPosts.size());
                for (MjvArtPost post : mjvArtPosts) {
                    Post temp = new Post();
                    temp.setRatio((float) post.getHeight() / post.getWidth());
                    temp.setPreUrl(post.getSmallPreview());
                    temp.setSampleUrl(post.getBigPreview());
                    temp.setRawUrl(post.getSmallPreview());
//                    temp.setTagArray(StringUtils.split(post.getTags(), "\b"));
//                    temp.setSource(post.getSource());
                    temp.setDesc("safebooru.org");
                    list.add(temp);
                }
                return list;
            }
        });
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
