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

package com.destin.moeviewer.model.zerochan;

public class ZeroChanPost {
//    <li >
//    <a href="/1991566" tabindex="1" style="width: 202px; ">
//    <span>10 Fav</span>
//    <img
//    src="http://s3.zerochan.net/Fate.stay.night.240.1991566.jpg"  (240 could be replace with 600 or full)
//    alt="Fate/stay night" title="1000x1200 1178kB"
//    style="width: 200px; height: 240px; " />
//    </a>
//    <p>
//    <a href="/Fate%2Fstay+night">Fate/stay night</a>
//
//    </p>
//    </li>

    private int id;
    private int favourite;
    private String previewUrl;
    private String alt;
    private String series;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
