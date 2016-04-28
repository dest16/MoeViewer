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

import com.destin.moeviewer.BasePresenter;
import com.destin.moeviewer.BaseView;
import com.destin.moeviewer.data.Provider;
import com.destin.moeviewer.model.common.Post;

import java.util.List;


public interface PostsContract {
    interface Presenter extends BasePresenter {
        void loadPosts(boolean refresh);

        void search();

        void autoComplete(String text);

        void setProvider(Provider provider);
    }

    interface View extends BaseView<Presenter> {
        void showPosts(List<Post> posts);

        void showSuggestion(String[] suggests);

        void showError(String error);

        boolean isActive();
    }


}
