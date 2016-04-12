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

import com.destin.moeviewer.model.Yander;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface YandeApi {
    /*
     * Posts
     */

    /**
     * @param tags  The tags to search for. Any tag combination that works on the web site will work here. This includes all the meta-tags.
     * @param limit How many posts you want to retrieve. There is a hard limit of 100 posts per request.
     * @param page  The page number.
     * @return list of Yande's image
     */
    @GET("post.json")
    Observable<List<Yander>> listYanders(@Query("tags") String tags, @Query("limit") int limit, @Query("page") int page);
    //create|update|destroy|Revert Tags|Vote

    /**
     * Tags
     */
//    @GET("tag.json")
//    Observable<List<Tag>> listTags(@Query("id") int id,@Query("limit") int limit,@Query("page") int page,)
}
