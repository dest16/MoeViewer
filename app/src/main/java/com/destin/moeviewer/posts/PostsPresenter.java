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

package com.destin.moeviewer.posts;


import com.destin.moeviewer.model.common.Post;
import com.destin.sehaikun.StringUtils;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class PostsPresenter implements PostsContract.Presenter {
    private final PostsContract.View mPostsView;
    private PostsContract.Provider mProvider;
    private int mPage = 0;

    public PostsPresenter(PostsContract.View postsView) {
        mPostsView = postsView;
        mPostsView.setPresenter(this);
    }

    @Override
    public void loadPosts(boolean refresh) {
        Observable.just(refresh ? mPage = 0 : mPage++)
                .flatMap(mProvider.getPostFunc())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postSubscriber);
    }

    @Override
    public void search() {

    }

    @Override
    public void autoComplete(String text) {
        if (StringUtils.isEmpty(text))
            return;
        Observable.just(text).flatMap(new Func1<String, Observable<String[]>>() {
            @Override
            public Observable<String[]> call(String s) {
                return null;
            }
        }).subscribe(autoCompleteSubscriber);
    }

    @Override
    public void setProvider(PostsContract.Provider provider) {
        mProvider = provider;
        loadPosts(true);
    }

    private Subscriber<String[]> autoCompleteSubscriber = new Subscriber<String[]>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String[] strings) {
            mPostsView.showSuggestion(strings);
        }
    };

    private Subscriber<List<Post>> postSubscriber = new Subscriber<List<Post>>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(List<Post> posts) {
            mPostsView.showPosts(posts);
        }
    };
}
