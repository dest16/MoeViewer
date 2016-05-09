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
     * "id": 1357405,
     * "name": "fate/extella",
     * "post_count": 14,
     * "related_tags": "fate/extra 14 fate/extella 14 fate_(series) 14 1girl 13 solo 10 caster_(fate/extra) 7 animal_ears 7 pink_hair 7 fox_ears 7 highres 7 looking_at_viewer 6 japanese_clothes 6 fox_tail 6 breasts 6 ribbon 6 long_hair 6 hair_ribbon 6 tail 6 yellow_eyes 6 smile 5 cleavage 5 detached_sleeves 5 brown_hair 4 yin_yang 4 blonde_hair 4",
     * "related_tags_updated_at": "2016-05-08T20:47:55.443-04:00",
     * "category": 3,
     * "created_at": "2016-03-15T13:54:12.106-04:00",
     * "updated_at": "2016-05-08T20:47:55.444-04:00",
     * "is_locked": false
     */

    private int id;
    private String name;
    @SerializedName("post_count")
    private int postCount;
    @SerializedName("related_tags")
    private String relatedTags;
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

    public String getRelatedTags() {
        return relatedTags;
    }

    public void setRelatedTags(String relatedTags) {
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
