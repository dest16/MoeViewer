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

package com.destin.moeviewer.model.common;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoeArtist {
    /**
     * id : 22997
     * name : (stag)
     * alias_id : null
     * group_id : null
     * urls : ["http://www.pixiv.net/member.php?id=62460","http://twitter.com/snobby_snob","http://twitpic.com/photos/snobby_snob","http://i1.pixiv.net/img07/img/666kkk/"]
     */

    private int id;
    private String name;
    @SerializedName("alias_id")
    private int aliasId;
    @SerializedName("group_id")
    private int groupId;
    private List<String> urls;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getAliasId() {
        return aliasId;
    }

    public void setAliasId(int aliasId) {
        this.aliasId = aliasId;
    }

    public Object getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<String> getUrls() {
        return urls;
    }


    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
