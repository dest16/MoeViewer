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


import com.destin.moeviewer.data.Provider;
import com.destin.moeviewer.model.common.Post;
import com.destin.sehaikun.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

public class PostsPresenter implements PostsContract.Presenter {
    private final PostsContract.View mPostsView;
    private CompositeSubscription mSubscriptions;
    private Provider mProvider;
    private PublishSubject<String> autoCompleteSubject;
    private PublishSubject<Integer> postSubject;
    private int mPage = 0;

    public PostsPresenter(PostsContract.View postsView, Provider provider) {
        mPostsView = postsView;
        mProvider = provider;
        mPostsView.setPresenter(this);
        mSubscriptions = new CompositeSubscription();
        autoCompleteSubject = PublishSubject.create();
        postSubject = PublishSubject.create();
    }


    @Override
    public void loadRecent(boolean refresh) {
        postSubject.onNext(refresh ? mPage = 0 : ++mPage);
    }

    @Override
    public void loadSearch(String tag) {
    }

    @Override
    public void autoComplete(String text) {
        autoCompleteSubject.onNext(text);
    }

    @Override
    public void setProvider(Provider provider) {
        mProvider = provider;
        subscribe();
    }

    @Override
    public void subscribe() {
        subscribeAutoComplete();
        subscribePosts();
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }

    private void subscribeAutoComplete() {
        Subscription subscription = autoCompleteSubject
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return !StringUtils.isEmpty(s);
                    }
                })
                .debounce(500, TimeUnit.MILLISECONDS)
                .flatMap(mProvider.getAutoCompleteFunc())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String[]>() {
                    @Override
                    public void call(String[] strings) {
                        mPostsView.showSuggestion(strings);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mPostsView.showError(throwable.getClass().getName());
                        subscribeAutoComplete();
                    }
                });
        mSubscriptions.add(subscription);
    }

    private void subscribePosts() {
        Subscription subscription = postSubject
                .compose(mProvider.getPostTrans())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<Post>>() {
                    @Override
                    public void call(List<Post> posts) {
                        if (mPage > 0) {
                            mPostsView.addPosts(posts);
                            mPostsView.showPostsAdded();
                        } else {
                            mPostsView.showPosts(posts);
                            mPostsView.showPostsShown();
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mPostsView.showError(throwable.getClass().getName());
                        if (mPage > 0) {
                            mPostsView.showPostsAdded();
                        } else {
                            mPostsView.showPostsShown();
                        }
                        subscribePosts();
                    }
                });
        mSubscriptions.add(subscription);
    }

}
