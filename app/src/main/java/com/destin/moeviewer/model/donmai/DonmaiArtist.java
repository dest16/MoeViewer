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

package com.destin.moeviewer.model.donmai;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DonmaiArtist {
    /**
     * id : 132983
     * created_at : 2016-04-13T05:48:20.553-04:00
     * name : herushii_(herushinkiiru)
     * updated_at : 2016-04-13T05:48:21.750-04:00
     * creator_id : 467044
     * is_active : true
     * group_name :
     * is_banned : false
     * other_names : 減るしィ herushinkiiru zentoba1980
     * urls : [{"id":1178927,"artist_id":132983,"url":"https://twitter.com/zentoba1980","normalized_url":"http://twitter.com/zentoba1980/","created_at":"2016-04-13T05:48:21.731-04:00","updated_at":"2016-04-13T05:48:21.731-04:00"},{"id":1178926,"artist_id":132983,"url":"http://www.pixiv.net/member.php?id=2336251","normalized_url":"http://www.pixiv.net/member.php?id=2336251/","created_at":"2016-04-13T05:48:21.695-04:00","updated_at":"2016-04-13T05:48:21.695-04:00"},{"id":1178925,"artist_id":132983,"url":"http://i3.pixiv.net/img-original/img/2015/02/28/02/12/08/49001502_p0.jpg","normalized_url":"http://img.pixiv.net/img/herushinkiiru/","created_at":"2016-04-13T05:48:21.666-04:00","updated_at":"2016-04-13T05:48:21.666-04:00"}]
     */

    private int id;
    @SerializedName("created_at")
    private String createdAt;
    private String name;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("creator_id")
    private int creatorId;
    @SerializedName("is_active")
    private boolean isActive;
    @SerializedName("group_name")
    private String groupName;
    @SerializedName("is_banned")
    private boolean isBanned;
    @SerializedName("other_names")
    private String otherNames;
    /**
     * id : 1178927
     * artist_id : 132983
     * url : https://twitter.com/zentoba1980
     * normalized_url : http://twitter.com/zentoba1980/
     * created_at : 2016-04-13T05:48:21.731-04:00
     * updated_at : 2016-04-13T05:48:21.731-04:00
     */

    private List<ArtistUrl> urls;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isIsBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public List<ArtistUrl> getUrls() {
        return urls;
    }

    public void setUrls(List<ArtistUrl> urls) {
        this.urls = urls;
    }

    public static class ArtistUrl {
        private int id;
        @SerializedName("artist_id")
        private int artistId;
        private String url;
        @SerializedName("normalized_url")
        private String normalizedUrl;
        @SerializedName("created_at")
        private String createdAt;
        @SerializedName("updated_at")
        private String updatedAt;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getArtistId() {
            return artistId;
        }

        public void setArtistId(int artistId) {
            this.artistId = artistId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getNormalizedUrl() {
            return normalizedUrl;
        }

        public void setNormalizedUrl(String normalizedUrl) {
            this.normalizedUrl = normalizedUrl;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}
