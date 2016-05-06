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

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.destin.moeviewer.R;
import com.destin.moeviewer.adapter.PostAdapter;
import com.destin.moeviewer.model.common.Post;
import com.destin.moeviewer.BaseFragment;
import com.destin.moeviewer.widget.MaterialSearchView;
import com.destin.sehaikun.LayoutUtils;
import com.destin.sehaikun.ResourceUtils;
import com.destin.sehaikun.StringUtils;
import com.hippo.easyrecyclerview.EasyRecyclerView;
import com.hippo.easyrecyclerview.MarginItemDecoration;
import com.hippo.refreshlayout.RefreshLayout;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.functions.Action1;
import rx.functions.Func1;
import rx.subjects.PublishSubject;


public class PostFragment extends BaseFragment
        implements PostsContract.View, RefreshLayout.OnRefreshListener,
        EasyRecyclerView.OnItemClickListener, EasyRecyclerView.OnItemLongClickListener,
        MaterialSearchView.OnQueryTextListener, Toolbar.OnMenuItemClickListener {
    private RefreshLayout mRefreshLayout;
    private EasyRecyclerView mRecyclerView;
    private Toolbar mToolbar;
    private MaterialSearchView mSearchView;

    private PostAdapter mAdapter;
    private PostsContract.Presenter mPresenter;
    private PublishSubject<String> mSuggestSubject;

    @Override
    protected int layoutId() {
        return R.layout.fragment_post;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated2(Bundle savedInstanceState) {
        mRefreshLayout = $(R.id.refresh_layout);
        mRecyclerView = $(R.id.recycler_view);
        mToolbar = $(R.id.toolbar);
        mSearchView = $(R.id.search_view);

        mToolbar.setTitle(getActivity().getTitle());
        mToolbar.inflateMenu(R.menu.main);
        mToolbar.setOnMenuItemClickListener(this);
        mRefreshLayout.setHeaderColorSchemeResources(R.color.red_500, R.color.yellow_500, R.color.blue_500, R.color.green_500);
        mRefreshLayout.setFooterColorSchemeResources(R.color.green_500, R.color.blue_500, R.color.yellow_500, R.color.red_500);
        int barSize = ResourceUtils.getAttrValue(getContext(), android.R.attr.actionBarSize);
        mRefreshLayout.setHeaderTranslationY(barSize);

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setClipToPadding(false);
        int padding = LayoutUtils.dp2pix(getContext(), 4);
        mRecyclerView.addItemDecoration(new MarginItemDecoration(padding, padding, padding, padding, padding));
        mRecyclerView.setPadding(padding
                , padding + barSize, padding
                , padding);
        mRecyclerView.setDrawSelectorOnTop(true);
        mAdapter = new PostAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mSearchView.setSubmitOnClick(true);
        mSearchView.setOnQueryTextListener(this);
        mRecyclerView.addOnScrollListener(mOnScrollListener);
        mRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setOnItemClickListener(this);
        mRecyclerView.setOnItemLongClickListener(this);

        mSuggestSubject = PublishSubject.create();
        mSuggestSubject
                .debounce(500, TimeUnit.MILLISECONDS)
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return !StringUtils.isEmpty(s);
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        mPresenter.loadSuggestions(s);
                    }
                });

        mPresenter.subscribe();
        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setHeaderRefreshing(true);
            }
        });
        mPresenter.loadPosts(true, getSearchText());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.unsubscribe();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.search_item) {
            mSearchView.showSearch();
            return true;
        }
        return false;
    }

    @Override
    public void showPosts(List<Post> posts, boolean refresh) {
        if (refresh) {
            mAdapter.mList = posts;
            mAdapter.notifyDataSetChanged();
        } else {
            mAdapter.mList.addAll(posts);
            mAdapter.notifyItemRangeInserted(mAdapter.mList.size() - posts.size(), posts.size());
        }
    }

    @Override
    public void completeLoadPosts(boolean refresh) {
        if (refresh) mRefreshLayout.setHeaderRefreshing(false);
        else mRefreshLayout.setFooterRefreshing(false);
    }


    @Override
    public void showSuggestions(String[] suggests) {
        mSearchView.setSuggestions(suggests);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPostsShown() {
        mRefreshLayout.setHeaderRefreshing(false);
    }

    @Override
    public void showPostsAdded() {
        mRefreshLayout.setFooterRefreshing(false);
    }


    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setPresenter(@NonNull PostsContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onHeaderRefresh() {
        mPresenter.loadPosts(true, getSearchText());
    }

    @Override
    public void onFooterRefresh() {
        mPresenter.loadPosts(false, getSearchText());
    }

    @Override
    public boolean onItemClick(EasyRecyclerView parent, View view, int position, long id) {


        return false;
    }

    @Override
    public boolean onItemLongClick(EasyRecyclerView parent, View view, int position, long id) {
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        String trim = query.trim();
        mToolbar.setSubtitle(trim);
        mRefreshLayout.setHeaderRefreshing(true);
        mPresenter.loadPosts(true, trim);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mSuggestSubject.onNext(newText);
        return true;
    }

    private String getSearchText() {
        CharSequence sub = mToolbar.getSubtitle();
        return sub != null ? sub.toString() : null;
    }

    private final RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if (!mRefreshLayout.isRefreshing() && mRefreshLayout.isAlmostBottom()) {
                // Get next page
                mRefreshLayout.setFooterRefreshing(true);
                onFooterRefresh();
            }
        }
    };
}
