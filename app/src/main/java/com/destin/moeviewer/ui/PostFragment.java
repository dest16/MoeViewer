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

package com.destin.moeviewer.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.destin.moeviewer.R;
import com.destin.moeviewer.adapter.PostAdapter;
import com.hippo.easyrecyclerview.EasyRecyclerView;
import com.hippo.refreshlayout.RefreshLayout;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class PostFragment extends BaseFragment implements RefreshLayout.OnRefreshListener, EasyRecyclerView.OnItemClickListener {
    private RefreshLayout mRefreshLayout;
    private EasyRecyclerView mRecyclerView;
    private Func1<String, Observable<String[]>> mAutoInputFunc;
//    private Func1<Object, Observable<>>
    private PostAdapter mAdapter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_recycler;
    }


    @Override
    public void onViewCreated2(Bundle savedInstanceState) {
        mRefreshLayout = $(R.id.refresh_layout);
        mRecyclerView = $(R.id.recycler_view);
        mRefreshLayout.setHeaderColorSchemeResources(
                R.color.red_500, R.color.green_500, R.color.yellow_500, R.color.blue_500);
        mRefreshLayout.setFooterColorSchemeResources(
                R.color.blue_500, R.color.yellow_500, R.color.green_500, R.color.red_500);
        mRefreshLayout.setOnRefreshListener(this);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setOnItemClickListener(this);
    }

    @Override
    public void onHeaderRefresh() {
//        Observable.just(null).flatMap(new Func1<Object, Observable<List<Post>>>() {
//            @Override
//            public Observable<List<Post>> call(Object o) {
//                Retrofit retrofit = new Retrofit.Builder().build();
//                return retrofit.create(MoeApi.class).listPosts();
//            }
//        });
    }

    @Override
    public void onFooterRefresh() {

    }

    @Override
    public boolean onItemClick(EasyRecyclerView parent, View view, int position, long id) {

        return false;
    }


    public PostFragment setAutoInputTransformer(@Nullable Func1<String, Observable<String[]>> func) {
        mAutoInputFunc = func;
        return this;
    }

    public Func1<String, Observable<String[]>> getAutoInputTransformer() {
        return mAutoInputFunc;
    }


    private Subscriber postSubscriber = new Subscriber() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(Object o) {
            //                mAdapter.setPosts;
//              mAdapter.notifyDataSetChanged();
        }
    };
}
