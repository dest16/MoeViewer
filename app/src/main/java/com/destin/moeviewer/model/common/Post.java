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

public class Post {

    /**
     * id : 351739
     * tags : animal_ears cleavage dress fate/apocrypha fate/grand_order fate/stay_night heels no_bra skirt_lift thighhighs
     * created_at : 1460212488
     * creator_id : 267411
     * author : 434332173
     * change : 1860444
     * source : http://www.pixiv.net/member_illust.php?mode=medium&illust_id=56265917
     * score : 25
     * md5 : 241ef9b181e08ce4b106ef4d1a66b3b5
     * file_size : 1344728
     * file_url : https://files.yande.re/image/241ef9b181e08ce4b106ef4d1a66b3b5/yande.re%20351739%20animal_ears%20cleavage%20dress%20fate_apocrypha%20fate_grand_order%20fate_stay_night%20heels%20no_bra%20skirt_lift%20thighhighs.png
     * is_shown_in_index : true
     * preview_url : https://assets.yande.re/data/preview/24/1e/241ef9b181e08ce4b106ef4d1a66b3b5.jpg
     * preview_width : 102
     * preview_height : 150
     * actual_preview_width : 205
     * actual_preview_height : 300
     * sample_url : https://files.yande.re/sample/241ef9b181e08ce4b106ef4d1a66b3b5/yande.re%20351739%20sample%20animal_ears%20cleavage%20dress%20fate_apocrypha%20fate_grand_order%20fate_stay_night%20heels%20no_bra%20skirt_lift%20thighhighs.jpg
     * sample_width : 1023
     * sample_height : 1500
     * sample_file_size : 171476
     * jpeg_url : https://files.yande.re/jpeg/241ef9b181e08ce4b106ef4d1a66b3b5/yande.re%20351739%20animal_ears%20cleavage%20dress%20fate_apocrypha%20fate_grand_order%20fate_stay_night%20heels%20no_bra%20skirt_lift%20thighhighs.jpg
     * jpeg_width : 1500
     * jpeg_height : 2200
     * jpeg_file_size : 370184
     * rating : q
     * has_children : false
     * parent_id : null
     * status : active
     * width : 1500
     * height : 2200
     * is_held : false
     * frames_pending_string :
     * frames_pending : []
     * frames_string :
     * frames : []
     */

    private int id;
    private String tags;
    @SerializedName("created_at")
    private int createdAt;
    @SerializedName("creator_id")
    private int creatorId;
    private String author;
    private int change;
    private String source;
    private int score;
    private String md5;
    @SerializedName("file_size")
    private int fileSize;
    @SerializedName("file_url")
    private String fileUrl;
    @SerializedName("is_shown_in_index")
    private boolean isShownInIndex;
    @SerializedName("preview_url")
    private String previewUrl;
    @SerializedName("preview_width")
    private int previewWidth;
    @SerializedName("preview_height")
    private int previewHeight;
    @SerializedName("actual_preview_width")
    private int actualPreviewWidth;
    @SerializedName("actual_preview_height")
    private int actualPreviewHeight;
    @SerializedName("sample_url")
    private String sampleUrl;
    @SerializedName("sample_width")
    private int sampleWidth;
    @SerializedName("sample_height")
    private int sampleHeight;
    @SerializedName("sample_file_size")
    private int sampleFileSize;
    @SerializedName("jpeg_url")
    private String jpegUrl;
    @SerializedName("jpeg_width")
    private int jpegWidth;
    @SerializedName("jpeg_height")
    private int jpegHeight;
    @SerializedName("jpeg_file_size")
    private int jpegFileSize;
    private String rating;
    @SerializedName("has_children")
    private boolean hasChildren;
    @SerializedName("parent_id")
    private Object parentId;
    private String status;
    private int width;
    private int height;
    @SerializedName("is_held")
    private boolean isHeld;
    @SerializedName("frames_pending_string")
    private String framesPendingString;
    @SerializedName("frames_string")
    private String framesString;
    @SerializedName("frames_pending")
    private List<String> framesPending;
    private List<String> frames;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getChange() {
        return change;
    }

    public void setChange(int change) {
        this.change = change;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public boolean isIsShownInIndex() {
        return isShownInIndex;
    }

    public void setIsShownInIndex(boolean isShownInIndex) {
        this.isShownInIndex = isShownInIndex;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
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

    public int getActualPreviewWidth() {
        return actualPreviewWidth;
    }

    public void setActualPreviewWidth(int actualPreviewWidth) {
        this.actualPreviewWidth = actualPreviewWidth;
    }

    public int getActualPreviewHeight() {
        return actualPreviewHeight;
    }

    public void setActualPreviewHeight(int actualPreviewHeight) {
        this.actualPreviewHeight = actualPreviewHeight;
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

    public int getSampleFileSize() {
        return sampleFileSize;
    }

    public void setSampleFileSize(int sampleFileSize) {
        this.sampleFileSize = sampleFileSize;
    }

    public String getJpegUrl() {
        return jpegUrl;
    }

    public void setJpegUrl(String jpegUrl) {
        this.jpegUrl = jpegUrl;
    }

    public int getJpegWidth() {
        return jpegWidth;
    }

    public void setJpegWidth(int jpegWidth) {
        this.jpegWidth = jpegWidth;
    }

    public int getJpegHeight() {
        return jpegHeight;
    }

    public void setJpegHeight(int jpegHeight) {
        this.jpegHeight = jpegHeight;
    }

    public int getJpegFileSize() {
        return jpegFileSize;
    }

    public void setJpegFileSize(int jpegFileSize) {
        this.jpegFileSize = jpegFileSize;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isIsHeld() {
        return isHeld;
    }

    public void setIsHeld(boolean isHeld) {
        this.isHeld = isHeld;
    }

    public String getFramesPendingString() {
        return framesPendingString;
    }

    public void setFramesPendingString(String framesPendingString) {
        this.framesPendingString = framesPendingString;
    }

    public String getFramesString() {
        return framesString;
    }

    public void setFramesString(String framesString) {
        this.framesString = framesString;
    }

    public List<String> getFramesPending() {
        return framesPending;
    }

    public void setFramesPending(List<String> framesPending) {
        this.framesPending = framesPending;
    }

    public List<String> getFrames() {
        return frames;
    }

    public void setFrames(List<String> frames) {
        this.frames = frames;
    }


}
