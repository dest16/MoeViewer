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

package com.destin.moeviewer.model.minitokyo;

public class MiniTokyoPost {
//    <li
//            >
//    <a href="http://gallery.minitokyo.net/view/626364"
//    style="width: 182px; " tabindex="1">
//    <img
//    src="http://static3.minitokyo.net/thumbs/14/27/626364.jpg"
//                              thumbs could be view,downloads(static3 should be replaced by static)
//    style="
//    border: 1px solid #000;
//    "
//    alt="The Legend of Heroes: Zero no Kiseki" title="6984x4848" />
//    </a>
//    <p>
//    <a href="http://www.minitokyo.net/The+Legend+of+Heroes%3A+Zero+no+Kiseki">The Legend of Heroes: Zero no Kiseki</a>
//    </p>
//    </li>


    private int id;
    private int rawWidth;
    private int rawHeight;
    private String previewUrl;
    private String alt;
    private String series;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRawWidth() {
        return rawWidth;
    }

    public void setRawWidth(int rawWidth) {
        this.rawWidth = rawWidth;
    }

    public int getRawHeight() {
        return rawHeight;
    }

    public void setRawHeight(int rawHeight) {
        this.rawHeight = rawHeight;
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
