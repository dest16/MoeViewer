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

public class ZeroChanTag {
//    <li>
//    <a href="/DURARARA%21%21" class="child-thumb" style="background-image: url(http://s1.zerochan.net/75/05/44/929705.jpg)"></a>
//    <h3>
//    <a href="/DURARARA%21%21">DURARARA!!</a>
//    </h3>
//    <a href="/Light+Novels">Light Novels</a>
//    <br />
//    <span>Series 30,506</span>
//
//    </li>

    private String name;
    private String thumbUrl;
    private String parent;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
