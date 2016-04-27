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
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.destin.moeviewer.R;
import com.destin.moeviewer.adapter.PostAdapter;
import com.destin.moeviewer.model.common.Post;
import com.destin.moeviewer.ui.BaseFragment;
import com.destin.moeviewer.widget.MaterialSearchView;
import com.destin.sehaikun.LayoutUtils;
import com.destin.sehaikun.ResourceUtils;
import com.hippo.easyrecyclerview.EasyRecyclerView;
import com.hippo.easyrecyclerview.MarginItemDecoration;
import com.hippo.refreshlayout.RefreshLayout;

import java.util.List;


public class PostFragment extends BaseFragment implements PostsContract.View, RefreshLayout.OnRefreshListener, EasyRecyclerView.OnItemClickListener, EasyRecyclerView.OnItemLongClickListener {
    private RefreshLayout mRefreshLayout;
    private EasyRecyclerView mRecyclerView;
    private Toolbar mToolbar;
    private MaterialSearchView mSearchView;

    private PostAdapter mAdapter;
    private PostsContract.Presenter mPresenter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_post;
    }

    @Override
    public void onViewCreated2(Bundle savedInstanceState) {
        mRefreshLayout = $(R.id.refresh_layout);
        mRecyclerView = $(R.id.recycler_view);
        mToolbar = $(R.id.toolbar);
        mSearchView = $(R.id.search_view);

        mToolbar.setTitle(getActivity().getTitle());
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
        mAdapter=new PostAdapter();
        mRecyclerView.setAdapter(mAdapter);
        mRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setOnItemClickListener(this);
        mRecyclerView.setOnItemLongClickListener(this);
    }

    @Override
    public void showPosts(List<Post> posts) {
        mAdapter.mList = posts;
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSuggestion(String[] suggests) {
        mSearchView.setSuggestions(suggests);
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
        mPresenter.loadPosts(true);
    }

    @Override
    public void onFooterRefresh() {

    }

    @Override
    public boolean onItemClick(EasyRecyclerView parent, View view, int position, long id) {
        return false;
    }

    @Override
    public boolean onItemLongClick(EasyRecyclerView parent, View view, int position, long id) {
        return false;
    }
}
