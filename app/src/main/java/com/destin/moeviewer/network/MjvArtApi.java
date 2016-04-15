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

import com.destin.moeviewer.model.mjvart.MjvArtPost;
import com.destin.moeviewer.model.mjvart.MjvArtTag;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * api of
 * https://anime-pictures.net/
 */
public interface MjvArtApi {


    /**
     * @param page         the page number
     * @param postsPerPage returned max size
     * @param searchTag    tags searched (separated by || or &&, no spaces)
     * @param deniedTags   tags should be parted (separated by || or &&, no spaces)
     * @param orderBy      can be date,date_r,rating,views,size,tag_num
     * @param ldate        post recent time,can be 0(anytime),3(past day),1(past week),2(past month)
     * @param extJpg       ext filter :jpg
     * @param extPng       ext filter :png
     * @param extGif       ext filter :gif
     * @return list of post
     */
    @GET("pictures/view_posts/{page}?lang=en&type=json")
    Observable<List<MjvArtPost>> listPosts(
            @Path("page") int page, @Query("posts_per_page") int postsPerPage, @Query("search_tag") String searchTag,
            @Query("denied_tags") String deniedTags, @Query("order_by") String orderBy, @Query("ldate") int ldate,
            @Query("ext_jpg") String extJpg, @Query("ext_png") String extPng, @Query("ext_gif") String extGif);

    /**
     * @param tag tags contained (length should be at least 2)
     * @return list of tags
     */
    @POST("pictures/autocomplete_tag")
    Observable<List<MjvArtTag>> autoTags(@Field("tag") String tag);

}
