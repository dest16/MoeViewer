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

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.destin.moeviewer.BasePresenter;
import com.destin.moeviewer.BaseView;
import com.destin.moeviewer.data.Post;
import com.destin.moeviewer.data.source.MoeDataSource;

import java.util.List;


public interface PostsContract {
    interface Presenter extends BasePresenter {
        void loadPosts(boolean refresh, @Nullable String tag);

        void loadSuggestions(String text);

        void setProvider(@NonNull MoeDataSource source);
    }

    interface View extends BaseView<Presenter> {

        void showPosts(List<Post> posts, boolean refresh);

        void showSuggestions(String[] suggests);

        void showError(String error);

        void showPostsShown();

        void showPostsAdded();

        void completeLoadPosts(boolean refresh);

        boolean isActive();
    }
}
