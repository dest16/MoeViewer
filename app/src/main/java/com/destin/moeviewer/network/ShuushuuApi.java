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

import com.destin.moeviewer.model.shuushuu.ShuushuuPost;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * api of
 * http://e-shuushuu.net/
 */
public interface ShuushuuApi {
    /**
     * @param page       the page number.(15 item per page)
     * @param maxImageId the top post'id of the list(load more needed,first load obtain)
     * @return wrapped list of post (maybe has the parameter {@param maxImageId} )
     */
    @GET("app/index.php")
    Observable<List<ShuushuuPost>> listPosts(@Query("page") int page, @Query("max_image_id") int maxImageId);


    /**
     * @param artist
     * @param character
     * @param favorite
     * @param source
     * @param tag
     * @return list of post
     */
    @GET("app/search/process.php")
    Observable<List<ShuushuuPost>> search(
            @Query("artist") String artist, @Query("char") String character, @Query("fav") String favorite,
            @Query("source") String source, @Query("tags") String tag);

}