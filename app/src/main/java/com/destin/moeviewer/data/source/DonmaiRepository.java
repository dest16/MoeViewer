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
import com.destin.moeviewer.model.donmai.DonmaiPost;
import com.destin.moeviewer.model.donmai.DonmaiTag;
import com.destin.moeviewer.network.DonmaiApi;
import com.destin.moeviewer.util.MoeClient;
import com.destin.sehaikun.StringUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

public class DonmaiRepository implements MoeDataSource {
    private static final String URL = "http://danbooru.donmai.us/";
    private static final int POST_LIMIT = 20;
    private static DonmaiRepository sRepository;
    private DonmaiApi mDonmaiApi;

    private DonmaiRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(MoeClient.getClient())
                .baseUrl(URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mDonmaiApi = retrofit.create(DonmaiApi.class);
    }

    public static DonmaiRepository getInstance() {
        if (sRepository == null)
            sRepository = new DonmaiRepository();
        return sRepository;
    }


    private final Func1<List<DonmaiTag>, String[]> tagsToArray = donmaiTags -> {
        String[] array = new String[donmaiTags.size()];
        for (int i = 0; i < array.length; i++)
            array[i] = donmaiTags.get(i).getName();
        return array;
    };
    private final Func1<List<DonmaiPost>, List<Post>> toPostsFunc = donmaiPosts -> {
        List<Post> list = new ArrayList<>(donmaiPosts.size());
        for (DonmaiPost post : donmaiPosts) {
            Post temp = new Post();
            temp.setRatio((float) post.getImageHeight() / post.getImageWidth());
            temp.setPreUrl(URL + post.getPreviewFileUrl());
            temp.setSampleUrl(URL + post.getLargeFileUrl());
            temp.setRawUrl(URL + post.getFileUrl());
            temp.setTagArray(StringUtils.split(post.getTagString(), "\b"));
            temp.setSource(post.getSource());
            temp.setDesc("donmai.us");
            list.add(temp);
        }
        return list;
    };


    @Override
    public Observable<List<Post>> getRecentPosts(int page) {
        return mDonmaiApi.listPosts(POST_LIMIT, page + 1, null, null).map(toPostsFunc);
    }

    @Override
    public Observable<List<Post>> getSearchPosts(int page, String tag) {
        return mDonmaiApi.listPosts(POST_LIMIT, page + 1, tag + "*", null).map(toPostsFunc);
    }

    @Override
    public Observable<String[]> getSuggestions(String tag) {
        return mDonmaiApi.autoTags(tag + "*").map(tagsToArray);

    }
}
