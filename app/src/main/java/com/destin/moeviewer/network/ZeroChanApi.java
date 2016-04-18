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
 * http://www.zerochan.net/
 */
public interface ZeroChanApi {

    /**
     * @param s order ,can be id,fav(recent,popular)
     * @param p the page number (start with 1)
     * @return raw html
     */
    @GET
    Observable<String> listPosts(@Query("s") String s, @Query("p") int p);

    /**
     * @param tag can be:Meta Tags,the children of Meta Tags
     * @param s   order,can be tag,count(name,popular)
     * @param p   page number,start with 1(48 per page)
     * @return raw html
     */
    @GET("{tag}")
    Observable<String> listTags(@Path("tag") String tag, @Query("s") String s, @Query("p") int p);

    /**
     * @param q tag
     * @return tags string like (split with \\n): Samonya|Mangaka|
     * Sha Gojyo|Character|Saiyuki
     * Special A|Series|Minami Maki
     * Sa-dui|Mangaka|
     * Ninja-wolfie|Mangaka|
     */
    @GET("suggest?limit=8")
    Observable<String> autoTags(@Query("q") String q);

    /**
     * @param tag tag should be integral ,can fill with the return of {@link #autoTags(String)}
     * @param p   the page number (start with 1)
     * @return raw html
     */
    @GET("{tag}")
    Observable<String> search(@Path("tag") String tag, @Query("p") int p);
}
