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

import com.destin.moeviewer.model.donmai.DonmaiArtist;
import com.destin.moeviewer.model.donmai.DonmaiComment;
import com.destin.moeviewer.model.donmai.DonmaiPost;
import com.destin.moeviewer.model.donmai.DonmaiTag;
import com.destin.moeviewer.model.donmai.DonmaiWiki;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * api of
 * http://danbooru.donmai.us/
 */
public interface DonmaiApi {


//    200 OK: Request was successful
//    204 No Content: Request was successful
//    403 Forbidden: Access denied
//    404 Not Found: Not found
//    420 Invalid Record: Record could not be saved
//    421 User Throttled: User is throttled, try again later
//    422 Locked: The resource is locked and cannot be modified
//    423 Already Exists: Resource already exists
//    424 Invalid Parameters: The given parameters were invalid
//    500 Internal Server Error: Some unknown error occurred on the server
//    503 Service Unavailable: Server cannot currently handle the request, try again later

    /*
     * Posts
     */

    /**
     * @param limit How many posts you want to retrieve. There is a hard limit of 100 posts per request.
     * @param page  The page number.
     * @param tags  The tags to search for. Any tag combination that works on the web site will
     *              work here. This includes all the meta-tags.
     * @param raw   When this parameter is set the tags parameter will not be parsed for aliased
     *              tags, metatags or multiple tags, and will instead be parsed as a single literal tag.
     * @return list of post
     */
    @GET("posts.json")
    Observable<List<DonmaiPost>> listPosts(
            @Query("limit") int limit, @Query("page") int page, @Query("tags") String tags,
            @Query("raw") String raw);

    /*
     * Comments
     */

    /**
     * @param id the comment id
     * @return the detail of comment
     */
    @GET("comments/{id}.json")
    Observable<DonmaiComment> showComment(@Path("id") int id);

    /*
    * Artists
    */

    /**
     * @param name        This field has multiple uses depending on what the query starts with:
     *                    http Search for artist with this URL.
     *                    name: Search for artists with the given name as their base name.
     *                    other: Search for artists with the given name in their other names.
     *                    group: Search for artists belonging to the group with the given name.
     *                    status:banned Search for artists that are banned.
     *                    else Search for the given name in the base name and the other names.
     * @param id          The artist id.
     * @param creatorName
     * @param creatorId
     * @param isActive    Can be: true, false
     * @param isBanned    Can be: true, false
     * @param emptyOnly   Search for artists that have 0 posts. Can be: true
     * @param order       Can be: name, updated_at.
     * @return list of artist
     */
    @GET("artists.json")
    Observable<List<DonmaiArtist>> listArtists(
            @Query("name") String name, @Query("id") int id, @Query("creator_name") String creatorName,
            @Query("creator_id") int creatorId, @Query("is_active") boolean isActive, @Query("is_banned") boolean isBanned,
            @Query("empty_only") boolean emptyOnly, @Query("order") String order);


    /*
    * Tags
    */

    /**
     * @param nameMatches
     * @param category     Can be: 0, 1, 3, 4 (general, artist, copyright, character respectively)
     * @param hideEmpty   Can be: yes, no. Excludes tags with 0 posts when "yes".
     * @param order        Can be: name, date, count
     * @param hasWiki     Can be: yes, no
     * @param name         Allows searching for multiple tags with exact given names, separated by commas.
     *                     e.g. search[name]=touhou,original,k-on! would return the three listed tags.
     * @return list of tags
     */
    @GET("tags.json")
    Observable<List<DonmaiTag>> listTags(
            @Query("search[nameMatches]") String nameMatches, @Query("search[category]") int category,
            @Query("search[hideEmpty]") String hideEmpty, @Query("search[order]") String order,
            @Query("search[hasWiki]") String hasWiki, @Query("search[name]") String name);


    /**
     * @param nameMatches tag should end with *
     * @return list of tag (without date)
     */
    @GET("tags/autocomplete.json")
    Observable<List<DonmaiTag>> autoTags(@Query("search[name_matches]") String nameMatches);
    /*
    * Wiki
    */

    /**
     * @param title
     * @param creatorId
     * @param body_matches
     * @param other_names_match
     * @param creatorName
     * @param order             Can be: date, title.
     * @return list of wiki pages
     */
    @GET("wiki_pages.json")
    Observable<List<DonmaiWiki>> listWiki(
            @Query("search[title]") String title, @Query("search[creatorId]") int creatorId,
            @Query("search[body_matches]") String body_matches, @Query("search[other_names_match]") String other_names_match,
            @Query("search[creatorName]") String creatorName, @Query("search[order]") String order);
}
