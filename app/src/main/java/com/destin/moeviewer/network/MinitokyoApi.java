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

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * api of
 * http://www.minitokyo.net/
 * only show the scans
 */
public interface MinitokyoApi {
    /**
     * @param order can be favorites,id (popular,recent)
     * @param time  only when {$param order} is favorites,can be 0(all time),1(1 week),2(1 month),
     *              3(3 months),4(1 year)
     * @param page  the page number,start with 1
     * @return raw html
     */
    @GET("http://gallery.minitokyo.net/scans")
    Observable<String> listPosts(@Query("order") String order, @Query("time") Integer time, @Query("page") int page);

    /**
     * meta tags return the list of it's children,children tag return the content (contains the cid)
     *
     * @param tag   meta tags (Series,Mangaka & Studios,Games,Artbooks) or the children of meta tags
     * @param order can be tag,total (name,popular)
     * @param page  the page number,start with 1
     * @return raw html
     */
    @GET("{tag}")
    Observable<String> listTags(@Path("tag") String tag, @Query("order") String order, @Query("page") Integer page);


    /**
     * @param q tag
     * @return tags string like (split with \\n):
     * Females|Theme|
     * Males|Theme|
     * Ecchi|Theme|
     * Group|Theme|
     */
    @GET("suggest?limit=8")
    Observable<String> autoTags(@Query("q") String q);

    /**
     * @param tid   the tag id
     * @param order can be favorites,id(popular,recent)
     * @param page  the page number ,start with 1
     * @return raw html
     */
    @GET("http://browse.minitokyo.net/gallery?index=3")
    Observable<String> showPosts(@Query("tid") String tid, @Query("order") String order, @Query("page") int page);

}
