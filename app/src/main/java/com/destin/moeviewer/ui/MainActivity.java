/*
 *
 *  * Copyright 2016 dest16
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.destin.moeviewer.ui;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.destin.moeviewer.R;
import com.destin.moeviewer.adapter.PostAdapter;
import com.destin.moeviewer.model.common.Post;
import com.destin.moeviewer.network.LogInterceptor;
import com.destin.moeviewer.network.MoeApi;
import com.destin.moeviewer.widget.MaterialSearchView;
import com.destin.sehaikun.AssertUtils;
import com.destin.sehaikun.LayoutUtils;
import com.destin.sehaikun.ResourceUtils;
import com.hippo.easyrecyclerview.EasyRecyclerView;
import com.hippo.easyrecyclerview.MarginItemDecoration;
import com.hippo.refreshlayout.RefreshLayout;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;
    private MaterialSearchView mSearchView;
    private RefreshLayout mRefreshLayout;
    private EasyRecyclerView mRecyclerView;
    private PostAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        AssertUtils.assertNull(navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        mSearchView = (MaterialSearchView) findViewById(R.id.search_view);
        mRefreshLayout = (RefreshLayout) findViewById(R.id.refresh_layout);
        mRecyclerView = (EasyRecyclerView) findViewById(R.id.recycler_view);

        mRefreshLayout.setHeaderColorSchemeResources(R.color.red_500, R.color.yellow_500, R.color.blue_500, R.color.green_500);
        mRefreshLayout.setFooterColorSchemeResources(R.color.green_500, R.color.blue_500, R.color.yellow_500, R.color.red_500);
        int barSize = ResourceUtils.getAttrValue(this, android.R.attr.actionBarSize);
        mRefreshLayout.setHeaderTranslationY(barSize);

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setClipToPadding(false);
        int padding = LayoutUtils.dp2pix(this, 4);
        mRecyclerView.addItemDecoration(new MarginItemDecoration(padding, padding, padding, padding, padding));
        mRecyclerView.setPadding(padding
                , padding + barSize, padding
                , padding);
        mRecyclerView.setDrawSelectorOnTop(true);
        mAdapter = new PostAdapter();
        mRecyclerView.setAdapter(mAdapter);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new LogInterceptor()).build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://konachan.com/")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
        retrofit.create(MoeApi.class).listPosts(20, 0, "loli").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<List<Post>>() {
            @Override
            public void onCompleted() {
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(MainActivity.this, e.getClass().getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(List<Post> posts) {
                mAdapter.mList = posts;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else if (mSearchView.isSearchOpen()) {
            mSearchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (R.id.search_item == id) {
            mSearchView.showSearch();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        setTitle(item.getTitle());

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
