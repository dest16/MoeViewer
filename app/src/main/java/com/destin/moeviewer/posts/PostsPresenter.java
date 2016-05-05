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


import android.support.annotation.Nullable;

import com.destin.moeviewer.data.Provider;
import com.destin.moeviewer.model.common.Post;
import com.destin.moeviewer.util.SchedulersCompat;
import com.destin.sehaikun.StringUtils;

import java.util.List;

import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
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
    public void loadPosts(final boolean refresh, @Nullable String tag) {
        if (StringUtils.isEmpty(tag)) {
            Subscription subscription = mProvider.getRecentPosts(refresh ? mPage = 0 : ++mPage)
                    .compose(SchedulersCompat.<List<Post>>applyIoSchedulers())
                    .doAfterTerminate(new Action0() {
                        @Override
                        public void call() {
                            mPostsView.completeLoadPosts(refresh);
                        }
                    })
                    .subscribe(new Action1<List<Post>>() {
                        @Override
                        public void call(List<Post> posts) {
                            mPostsView.showPosts(posts, refresh);
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            mPostsView.showError(throwable.getClass().getName());
                        }
                    });
            mSubscriptions.add(subscription);
        } else {
            Subscription subscription = mProvider.getSearchPosts(refresh ? mPage = 0 : ++mPage, tag)
                    .compose(SchedulersCompat.<List<Post>>applyIoSchedulers())
                    .doAfterTerminate(new Action0() {
                        @Override
                        public void call() {
                            mPostsView.completeLoadPosts(refresh);
                        }
                    })
                    .subscribe(new Action1<List<Post>>() {
                        @Override
                        public void call(List<Post> posts) {
                            mPostsView.showPosts(posts, refresh);
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {
                            mPostsView.showError(throwable.getClass().getName());
                        }
                    });
            mSubscriptions.add(subscription);
        }

    }

//    @Override
//    public void loadSearch(String tag) {
//        Subscription subscription = mProvider.getPosts(refresh ? 0 : ++mPage)
//                .compose(SchedulersCompat.<List<Post>>applyIoSchedulers())
//                .doAfterTerminate(new Action0() {
//                    @Override
//                    public void call() {
//                        mPostsView.completeLoadPosts(refresh);
//                    }
//                })
//                .subscribe(new Action1<List<Post>>() {
//                    @Override
//                    public void call(List<Post> posts) {
//                        mPostsView.showPosts(posts, refresh);
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        mPostsView.showError(throwable.getClass().getName());
//                    }
//                });
//        mSubscriptions.add(subscription);
//    }

    @Override
    public void loadSuggestions(String text) {
        Subscription subscription = mProvider.getSuggestions(text)
                .compose(SchedulersCompat.<String[]>applyIoSchedulers())
                .subscribe(new Action1<String[]>() {
                    @Override
                    public void call(String[] strings) {
                        mPostsView.showSuggestions(strings);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mPostsView.showError(throwable.getClass().getName());
                    }
                });
        mSubscriptions.add(subscription);
    }

    @Override
    public void setProvider(Provider provider) {
        mProvider = provider;
        subscribe();
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }


}
