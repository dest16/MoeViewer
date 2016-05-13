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

package com.destin.moeviewer.model.mjvart;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MjvArtList {
    @SerializedName("max_pages")
    private int maxPages;
    @SerializedName("response_posts_count")
    private int responsePostsCount;
    @SerializedName("posts_per_page")
    private int postsPerPage;
    private List<MjvArtPost> posts;

    public int getMaxPages() {
        return maxPages;
    }

    public void setMaxPages(int maxPages) {
        this.maxPages = maxPages;
    }

    public int getResponsePostsCount() {
        return responsePostsCount;
    }

    public void setResponsePostsCount(int responsePostsCount) {
        this.responsePostsCount = responsePostsCount;
    }

    public int getPostsPerPage() {
        return postsPerPage;
    }

    public void setPostsPerPage(int postsPerPage) {
        this.postsPerPage = postsPerPage;
    }

    public List<MjvArtPost> getPosts() {
        return posts;
    }

    public void setPosts(List<MjvArtPost> posts) {
        this.posts = posts;
    }
}
