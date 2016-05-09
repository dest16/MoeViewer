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

package com.destin.moeviewer.network;

import com.destin.moeviewer.model.booru.BooruComment;
import com.destin.moeviewer.model.booru.BooruPost;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * api of
 * http://safebooru.org/
 * http://gelbooru.com/
 */
public interface BooruApi {


//You should never receive an error unless the server is overloaded or the search dies.
// In cases of the searcher breaking, you will receive a response success of "false" and
// a message stating "search down" or similiar.

    /**
     * @param limit How many posts you want to retrieve. There is a hard limit of 100 posts per request.
     * @param pid   The page number.
     * @param tags  The tags to search for. Any tag combination that works on the web site will
     *              work here. This includes all the meta-tags. See cheatsheet for more information.
     * @param cid   Change ID of the post. This is in Unix time so there are likely others with
     *              the same value if updated at the same time.
     * @param id    The post id.
     * @return list of post
     */
    @GET("index.php?page=dapi&s=post&q=index")
    Observable<List<BooruPost>> listPosts(
            @Query("limit") int limit, @Query("pid") int pid, @Query("tags") String tags,
            @Query("cid") Integer cid, @Query("id") Integer id);

    /**
     * @param postId The id number of the comment to retrieve.
     * @return list of comment
     */
    @GET("index.php?page=dapi&s=comment&q=index")
    Observable<BooruComment> listComments(@Query("post_id") int postId);

}
