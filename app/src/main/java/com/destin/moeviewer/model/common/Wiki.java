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

public class Wiki {
    /**
     * id : 344
     * created_at : 2009-08-09T20:13:32.845Z
     * updated_at : 2009-09-28T23:35:09.732Z
     * title : &love
     * body : ＆LOVE（アンドラブ）
     * Art by [[yuyi|Yuyi]].
     * <p/>
     * <<http://www.comet-web.com/products/andlove/index|Official Site>>
     * <<http://erogamescape.ddo.jp/~ap2/ero/toukei_kaiseki/game.php?game=12440#ad|Erogamescape>>
     * <<http://www.getchu.com/soft.phtml?id=634965|Getchu>>
     * updater_id : 22887
     * locked : false
     * version : 4
     */

    private int id;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    private String title;
    private String body;
    @SerializedName("updater_id")
    private int updaterId;
    private boolean locked;
    private int version;

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

    public int getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(int updaterId) {
        this.updaterId = updaterId;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Wiki{" +
                "id=" + id +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt=" + updatedAt +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", updaterId=" + updaterId +
                ", locked=" + locked +
                ", version=" + version +
                '}';
    }
}
