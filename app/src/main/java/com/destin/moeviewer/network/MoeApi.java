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

import android.support.annotation.StringDef;

import com.destin.moeviewer.model.common.Artist;
import com.destin.moeviewer.model.common.Comment;
import com.destin.moeviewer.model.common.Post;
import com.destin.moeviewer.model.common.Tag;
import com.destin.moeviewer.model.common.Wiki;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * api of
 * https://yande.re/
 * http://konachan.com/
 */
public interface MoeApi {
    String DATE = "date";
    String COUNT = "count";
    String NAME = "name";

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({DATE, COUNT, NAME})
    @interface Order {
    }


//    Status Code	Meaning
//    200 OK	Request was successful
//    403 Forbidden	Access denied
//    404 Not Found	Not found
//    420 Invalid Record	Record could not be saved
//    421 User Throttled	User is throttled, try again later
//    422 Locked	The resource is locked and cannot be modified
//    423 Already Exists	Resource already exists
//    424 Invalid Parameters	The given parameters were invalid
//    500 Internal Server Error	Some unknown error occurred on the server
//    503 Service Unavailable	Server cannot currently handle the request, try again later


    /*
     * Posts
     */

    /**
     * @param tags  The tags to search for. Any tag combination that works on the web site will
     *              work here. This includes all the meta-tags.
     * @param limit How many posts you want to retrieve. There is a hard limit of 100 posts per request.
     * @param page  The page number.start with 1
     * @return list of post
     */
    @GET("post.json")
    Observable<List<Post>> listPosts(
            @Query("limit") int limit, @Query("page") int page, @Query("tags") String tags);

    /*
     * Tags
     */

    /**
     * @param limit       How many tags to retrieve. Setting this to 0 will return every tag.
     *                    (default is 50)
     * @param page        The page number.
     * @param order       Can be date, count, or name.
     * @param id          The id number of the tag.
     * @param afterId     Return all tags that have an id number greater than this.
     * @param name        The exact name of the tag.
     * @param namePattern Search for any tag that has this parameter in its name.
     * @return list of tag
     */
    @GET("tag.json")
    Observable<List<Tag>> listTags(
            @Query("limit") Integer limit, @Query("page") Integer page, @Query("order") @Order String order,
            @Query("id") Integer id, @Query("after_id") Integer afterId, @Query("name") String name,
            @Query("name_pattern ") String namePattern);

    /*
     * Artists
     */

    /**
     * @param name  The name (or a fragment of the name) of the artist.
     * @param order Can be date or name.
     * @param page  The page number.
     * @return list of artist
     */
    @GET("artist.json")
    Observable<List<Artist>> listArtists(
            @Query("name") String name, @Query("order") String order, @Query("page") int page);


    /*
     * Comments
     */

    /**
     * somehow don't work
     *
     * @param id The id number of the comment to retrieve.
     * @return the comment
     */

    @GET("comment/show.json")
    Observable<Comment> showComment(@Query("id") int id);

    /*
     *Wiki
     *All titles must be exact (but case and whitespace don't matter).
     */

    /**
     * @param order How you want the pages ordered. Can be: title, date.
     * @param limit The number of pages to retrieve.(default is 25)
     * @param page  The page number.
     * @param query A word or phrase to search for.
     * @return list of wiki
     */
    @GET("wiki.json")
    Observable<List<Wiki>> listWiki(
            @Query("order") String order, @Query("limit") int limit, @Query("page") int page,
            @Query("query") String query);

    //continued
}
