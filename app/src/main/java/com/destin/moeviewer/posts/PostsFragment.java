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
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.destin.moeviewer.BaseFragment;
import com.destin.moeviewer.R;
import com.destin.moeviewer.data.Post;
import com.destin.moeviewer.widget.MaterialSearchView;
import com.destin.moeviewer.widget.StaggeredImageView;
import com.destin.sehaikun.LayoutUtils;
import com.destin.sehaikun.ResourceUtils;
import com.destin.sehaikun.StringUtils;
import com.hippo.easyrecyclerview.EasyRecyclerView;
import com.hippo.easyrecyclerview.MarginItemDecoration;
import com.hippo.refreshlayout.RefreshLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.subjects.PublishSubject;


public class PostsFragment extends BaseFragment
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

    public List<Post> mList = new ArrayList<>();

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

        mToolbar.setNavigationIcon(R.drawable.ic_menu);
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
                .filter(s -> !StringUtils.isEmpty(s))
                .subscribe(s -> {
                    mPresenter.loadSuggestions(s);
                });
        mPresenter.subscribe();
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
            mRecyclerView.scrollToPosition(0);
            mList.clear();
            mList.addAll(posts);
            mAdapter.notifyDataSetChanged();
        } else {
            mList.addAll(posts);
            mAdapter.notifyItemRangeInserted(mList.size() - posts.size(), posts.size());
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
    public void showTitle() {
        mToolbar.setTitle(getActivity().getTitle());
    }

    @Override
    public void showSubTitle(String title) {
        mToolbar.setSubtitle(title);
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (mRefreshLayout.isFooterRefreshing())
            mRefreshLayout.setFooterRefreshing(false);
        mRefreshLayout.setHeaderRefreshing(true);
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
        mRefreshLayout.setHeaderRefreshing(true);
        mPresenter.loadPosts(true, query.trim());
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

    private class PostAdapter extends RecyclerView.Adapter<PostHolder> {


        @Override
        public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_post, parent, false);
            return new PostHolder(view);
        }

        @Override
        public void onBindViewHolder(PostHolder holder, int position) {
            Post post = mList.get(position);
            holder.image.setRatio(post.getRatio());
            holder.desc.setText(post.getDesc());
            Picasso.with(holder.itemView.getContext()).load(mList.get(position).getPreUrl()).into(holder.image);
        }

        @Override
        public int getItemCount() {
            if (mList == null)
                return 0;
            return mList.size();
        }

    }

    private class PostHolder extends RecyclerView.ViewHolder {
        StaggeredImageView image;
        TextView desc;

        public PostHolder(View itemView) {
            super(itemView);
            image = (StaggeredImageView) itemView.findViewById(R.id.image_item_grid);
            desc = (TextView) itemView.findViewById(R.id.desc_item_grid);
        }
    }
}
