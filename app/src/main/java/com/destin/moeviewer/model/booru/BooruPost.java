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

package com.destin.moeviewer.model.booru;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "post")
public class BooruPost {


    /**
     * ----raw is xml----
     * <p>
     * height : 671
     * score : 0
     * file_url : http://safebooru.org/images/1661/e547f5ec0a654a6a104d8cac23f9d57a7279c4d3.png
     * parent_id :
     * sample_url : http://safebooru.org/images/1661/e547f5ec0a654a6a104d8cac23f9d57a7279c4d3.png
     * sample_width : 618
     * sample_height : 671
     * preview_url : http://safebooru.org/thumbnails/1661/thumbnail_e547f5ec0a654a6a104d8cac23f9d57a7279c4d3.png
     * rating : s
     * tags :  2boys bags_under_eyes ben_10 benjamin_kirby_tennyson black_eyes black_hair blush brown_hair english green_eyes hands_on_another's_face jin-nyeh kevin_ethan_levin male_focus multiple_boys open_mouth short_hair tsundere yaoi
     * id : 1739395
     * width : 618
     * change : 1460615425
     * md5 : 654d34741bf85e5cbd9fccd0174396c6
     * creator_id : 168
     * has_children : false
     * created_at : Thu Apr 14 08:30:25 +0200 2016
     * status : active
     * source : http://orig12.deviantart.net/d53b/f/2012/136/3/5/how_do_you_bevin_by_shiroiangelz-d4zzax9.png
     * has_notes : false
     * has_comments : false
     * preview_width : 138
     * preview_height : 150
     */
    @Attribute
    private int height;
    @Attribute
    private int score;
    @Attribute(name = "file_url")
    private String fileUrl;
    @Attribute(name = "parent_id")
    private String parentId;
    @Attribute(name = "sample_url")
    private String sampleUrl;
    @Attribute(name = "sample_width")
    private int sampleWidth;
    @Attribute(name = "sample_height")
    private int sampleHeight;
    @Attribute(name = "preview_url")
    private String previewUrl;
    @Attribute
    private String rating;
    @Attribute
    private String tags;
    @Attribute
    private int id;
    @Attribute
    private int width;
    @Attribute
    private int change;
    @Attribute
    private String md5;
    @Attribute(name = "creator_id")
    private int creatorId;
    @Attribute(name = "has_children")
    private boolean hasChildren;
    @Attribute(name = "created_at")
    private String createdAt;
    @Attribute
    private String status;
    @Attribute
    private String source;
    @Attribute(name = "has_notes")
    private boolean hasNotes;
    @Attribute(name = "has_comments")
    private boolean hasComments;
    @Attribute(name = "preview_width")
    private int previewWidth;
    @Attribute(name = "preview_height")
    private int previewHeight;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSampleUrl() {
        return sampleUrl;
    }

    public void setSampleUrl(String sampleUrl) {
        this.sampleUrl = sampleUrl;
    }

    public int getSampleWidth() {
        return sampleWidth;
    }

    public void setSampleWidth(int sampleWidth) {
        this.sampleWidth = sampleWidth;
    }

    public int getSampleHeight() {
        return sampleHeight;
    }

    public void setSampleHeight(int sampleHeight) {
        this.sampleHeight = sampleHeight;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isHasNotes() {
        return hasNotes;
    }

    public void setHasNotes(boolean hasNotes) {
        this.hasNotes = hasNotes;
    }

    public boolean isHasComments() {
        return hasComments;
    }

    public void setHasComments(boolean hasComments) {
        this.hasComments = hasComments;
    }

    public int getPreviewWidth() {
        return previewWidth;
    }

    public void setPreviewWidth(int previewWidth) {
        this.previewWidth = previewWidth;
    }

    public int getPreviewHeight() {
        return previewHeight;
    }

    public void setPreviewHeight(int previewHeight) {
        this.previewHeight = previewHeight;
    }
}
