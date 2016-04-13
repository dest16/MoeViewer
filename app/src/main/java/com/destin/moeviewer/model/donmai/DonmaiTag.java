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

public class DonmaiTag {
    /**
     * id : 1361966
     * name : kiss_from_behind
     * post_count : 1
     * related_tags : null
     * related_tags_updated_at : 2016-04-13T01:56:42.595-04:00
     * category : 0
     * created_at : 2016-04-13T03:45:24.934-04:00
     * updated_at : 2016-04-13T03:45:24.934-04:00
     * is_locked : false
     */

    private int id;
    private String name;
    @SerializedName("post_count")
    private int postCount;
    @SerializedName("related_tags")
    private Object relatedTags;
    @SerializedName("related_tags_updated_at")
    private String relatedTagsUpdatedAt;
    private int category;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("is_locked")
    private boolean isLocked;

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

    public int getPostCount() {
        return postCount;
    }

    public void setPostCount(int postCount) {
        this.postCount = postCount;
    }

    public Object getRelatedTags() {
        return relatedTags;
    }

    public void setRelatedTags(Object relatedTags) {
        this.relatedTags = relatedTags;
    }

    public String getRelatedTagsUpdatedAt() {
        return relatedTagsUpdatedAt;
    }

    public void setRelatedTagsUpdatedAt(String relatedTagsUpdatedAt) {
        this.relatedTagsUpdatedAt = relatedTagsUpdatedAt;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
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

    public boolean isIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }
}
