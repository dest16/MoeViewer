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

public class DonmaiWiki {
    /**
     * id : 74529
     * created_at : 2016-04-13T10:01:42.762-04:00
     * updated_at : 2016-04-13T10:02:03.743-04:00
     * title : dr.latency's_freak_report
     * body : Japanese name: 燕石博物誌　～ Dr.Latency's Freak Report

     The 8th Music CD from Team Shanghai Alice.

     Due for release on Reitaisai 13.
     * creator_id : 396686
     * is_locked : false
     * updater_id : 396686
     * other_names : 燕石博物誌
     * creator_name : Zansnae793
     * category_name : 3
     */

    private int id;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    private String title;
    private String body;
    @SerializedName("creator_id")
    private int creatorId;
    @SerializedName("is_locked")
    private boolean isLocked;
    @SerializedName("updater_id")
    private int updaterId;
    @SerializedName("other_names")
    private String otherNames;
    @SerializedName("creator_name")
    private String creatorName;
    @SerializedName("category_name")
    private int categoryName;

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

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public boolean isIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public int getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(int updaterId) {
        this.updaterId = updaterId;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public int getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(int categoryName) {
        this.categoryName = categoryName;
    }
}
