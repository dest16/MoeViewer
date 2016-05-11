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
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.destin.moeviewer.R;
import com.destin.moeviewer.data.source.DonmaiRepository;
import com.destin.moeviewer.data.source.KonachanRepository;
import com.destin.moeviewer.data.source.MinitokyoRepository;
import com.destin.moeviewer.data.source.SafebooruRepository;
import com.destin.moeviewer.data.source.ShuushuuRepository;
import com.destin.moeviewer.data.source.YandeRepository;
import com.destin.moeviewer.data.source.ZerochanRepository;
import com.destin.sehaikun.AssertUtils;

public class PostsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerLayout;

    private PostsPresenter mPostsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        AssertUtils.assertNull(navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);


        PostsFragment postsFragment = (PostsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_root);

        if (postsFragment == null) {
            postsFragment = new PostsFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_root, postsFragment).commit();
        }
        // Create the presenter
        setTitle(R.string.yande_menu_title);
        mPostsPresenter = new PostsPresenter(postsFragment, YandeRepository.getInstance());
//        // Load previously saved state, if available.
//        if (savedInstanceState != null) {
//            TasksFilterType currentFiltering =
//                    (TasksFilterType) savedInstanceState.getSerializable(CURRENT_FILTERING_KEY);
//            mTasksPresenter.setFiltering(currentFiltering);
//        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
//        outState.putSerializable(CURRENT_FILTERING_KEY, mTasksPresenter.getFiltering());

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        setTitle(item.getTitle());
        switch (item.getItemId()) {
            case R.id.nav_yande:
                mPostsPresenter.setProvider(YandeRepository.getInstance());
                break;
            case R.id.nav_konachan:
                mPostsPresenter.setProvider(KonachanRepository.getInstance());
                break;
            case R.id.nav_donmai:
                mPostsPresenter.setProvider(DonmaiRepository.getInstance());
                break;
            case R.id.nav_safebooru:
                mPostsPresenter.setProvider(SafebooruRepository.getInstance());
                break;
            case R.id.nav_shuushuu:
                mPostsPresenter.setProvider(ShuushuuRepository.getInstance());
                break;
            case R.id.nav_zerochan:
                mPostsPresenter.setProvider(ZerochanRepository.getInstance());
                break;
            case R.id.nav_monitokyo:
                mPostsPresenter.setProvider(MinitokyoRepository.getInstance());
                break;
            default:
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
