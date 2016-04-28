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


import android.os.NetworkOnMainThreadException;

import com.destin.moeviewer.data.Provider;
import com.destin.moeviewer.model.common.Post;
import com.destin.sehaikun.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

public class PostsPresenter implements PostsContract.Presenter {
    private final PostsContract.View mPostsView;
    private Provider mProvider;
    private BehaviorSubject<String> autoCompleteSubject;
    private BehaviorSubject<Integer> postSubject;
    private int mPage = 0;

    public PostsPresenter(PostsContract.View postsView, Provider provider) {
        mPostsView = postsView;
        mProvider = provider;
        mPostsView.setPresenter(this);
        initSubject();
        loadPosts(true);
    }

    void initSubject() {
        autoCompleteSubject = BehaviorSubject.create();
        autoCompleteSubject
                .debounce(500, TimeUnit.MILLISECONDS)
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return !StringUtils.isEmpty(s);
                    }
                })
                .flatMap(mProvider.getAutoCompleteFunc())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(autoCompleteSubscriber);

        postSubject = BehaviorSubject.create();
        postSubject
                .flatMap(mProvider.getPostFunc())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(postSubscriber);
    }


    @Override
    public void loadPosts(boolean refresh) {
        postSubject.onNext(0);
    }

    @Override
    public void search() {

    }

    @Override
    public void autoComplete(String text) {
        autoCompleteSubject.onNext(text + "*");
    }

    @Override
    public void setProvider(Provider provider) {
        mProvider = provider;
        loadPosts(true);
    }

    private Subscriber<String[]> autoCompleteSubscriber = new Subscriber<String[]>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mPostsView.showError(e.getMessage());
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
            mPostsView.showError(e.getClass().getName());
        }

        @Override
        public void onNext(List<Post> posts) {
            mPostsView.showPosts(posts);
        }
    };

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}
