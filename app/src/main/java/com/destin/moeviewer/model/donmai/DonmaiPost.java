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

public class DonmaiPost {

    /**
     * id : 2329191
     * created_at : 2016-04-13T04:55:39.922-04:00
     * uploader_id : 77318
     * score : 1
     * source : Prototype G.I. JOE Vehicle Toy Art
     * md5 : a5e3f888490b6624837e2108fbc92c41
     * last_comment_bumped_at : null
     * rating : s
     * image_width : 1604
     * image_height : 920
     * tag_string : artist_request character_request firing g.i._joe highres military military_vehicle prototype realistic science_fiction soldier tank vehicle
     * is_note_locked : false
     * fav_count : 1
     * file_ext : jpg
     * last_noted_at : null
     * is_rating_locked : false
     * parent_id : null
     * has_children : false
     * approver_id : null
     * tag_count_general : 12
     * tag_count_artist : 0
     * tag_count_character : 0
     * tag_count_copyright : 1
     * file_size : 433848
     * is_status_locked : false
     * fav_string : fav:77318
     * pool_string :
     * up_score : 1
     * down_score : 0
     * is_pending : true
     * is_flagged : false
     * is_deleted : false
     * tag_count : 13
     * updated_at : 2016-04-13T04:55:39.922-04:00
     * is_banned : false
     * pixiv_id : null
     * last_commented_at : null
     * has_active_children : false
     * bit_flags : 0
     * uploader_name : Kronnang Dunn
     * has_large : true
     * tag_string_artist :
     * tag_string_character :
     * tag_string_copyright : g.i._joe
     * tag_string_general : artist_request character_request firing highres military military_vehicle prototype realistic science_fiction soldier tank vehicle
     * has_visible_children : false
     * file_url : /data/a5e3f888490b6624837e2108fbc92c41.jpg
     * large_file_url : /data/sample/sample-a5e3f888490b6624837e2108fbc92c41.jpg
     * preview_file_url : /data/preview/a5e3f888490b6624837e2108fbc92c41.jpg
     */

    private int id;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("uploader_id")
    private int uploaderId;
    private int score;
    private String source;
    private String md5;
    @SerializedName("last_comment_bumped_at")
    private Object lastCommentBumpedAt;
    private String rating;
    @SerializedName("image_width")
    private int imageWidth;
    @SerializedName("image_height")
    private int imageHeight;
    @SerializedName("tag_string")
    private String tagString;
    @SerializedName("is_note_locked")
    private boolean isNoteLocked;
    @SerializedName("fav_count")
    private int favCount;
    @SerializedName("file_ext")
    private String fileExt;
    @SerializedName("last_noted_at")
    private Object lastNotedAt;
    @SerializedName("is_rating_locked")
    private boolean isRatingLocked;
    @SerializedName("parent_id")
    private Object parentId;
    @SerializedName("has_children")
    private boolean hasChildren;
    @SerializedName("approver_id")
    private Object approverId;
    @SerializedName("tag_count_general")
    private int tagCountGeneral;
    @SerializedName("tag_count_artist")
    private int tagCountArtist;
    @SerializedName("tag_count_character")
    private int tagCountCharacter;
    @SerializedName("tag_count_copyright")
    private int tagCountCopyright;
    @SerializedName("file_size")
    private int fileSize;
    @SerializedName("is_status_locked")
    private boolean isStatusLocked;
    @SerializedName("fav_string")
    private String favString;
    @SerializedName("pool_string")
    private String poolString;
    @SerializedName("up_score")
    private int upScore;
    @SerializedName("down_score")
    private int downScore;
    @SerializedName("is_pending")
    private boolean isPending;
    @SerializedName("is_flagged")
    private boolean isFlagged;
    @SerializedName("is_deleted")
    private boolean isDeleted;
    @SerializedName("tag_count")
    private int tagCount;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("is_banned")
    private boolean isBanned;
    @SerializedName("pixiv_id")
    private Object pixivId;
    @SerializedName("last_commented_at")
    private Object lastCommentedAt;
    @SerializedName("has_active_children")
    private boolean hasActiveChildren;
    @SerializedName("bit_flags")
    private int bitFlags;
    @SerializedName("uploader_name")
    private String uploaderName;
    @SerializedName("has_large")
    private boolean hasLarge;
    @SerializedName("tag_string_artist")
    private String tagStringArtist;
    @SerializedName("tag_string_character")
    private String tagStringCharacter;
    @SerializedName("tag_string_copyright")
    private String tagStringCopyright;
    @SerializedName("tag_string_general")
    private String tagStringGeneral;
    @SerializedName("has_visible_children")
    private boolean hasVisibleChildren;
    @SerializedName("file_url")
    private String fileUrl;
    @SerializedName("large_file_url")
    private String largeFileUrl;
    @SerializedName("preview_file_url")
    private String previewFileUrl;

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

    public int getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(int uploaderId) {
        this.uploaderId = uploaderId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Object getLastCommentBumpedAt() {
        return lastCommentBumpedAt;
    }

    public void setLastCommentBumpedAt(Object lastCommentBumpedAt) {
        this.lastCommentBumpedAt = lastCommentBumpedAt;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getTagString() {
        return tagString;
    }

    public void setTagString(String tagString) {
        this.tagString = tagString;
    }

    public boolean isIsNoteLocked() {
        return isNoteLocked;
    }

    public void setIsNoteLocked(boolean isNoteLocked) {
        this.isNoteLocked = isNoteLocked;
    }

    public int getFavCount() {
        return favCount;
    }

    public void setFavCount(int favCount) {
        this.favCount = favCount;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public Object getLastNotedAt() {
        return lastNotedAt;
    }

    public void setLastNotedAt(Object lastNotedAt) {
        this.lastNotedAt = lastNotedAt;
    }

    public boolean isIsRatingLocked() {
        return isRatingLocked;
    }

    public void setIsRatingLocked(boolean isRatingLocked) {
        this.isRatingLocked = isRatingLocked;
    }

    public Object getParentId() {
        return parentId;
    }

    public void setParentId(Object parentId) {
        this.parentId = parentId;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public Object getApproverId() {
        return approverId;
    }

    public void setApproverId(Object approverId) {
        this.approverId = approverId;
    }

    public int getTagCountGeneral() {
        return tagCountGeneral;
    }

    public void setTagCountGeneral(int tagCountGeneral) {
        this.tagCountGeneral = tagCountGeneral;
    }

    public int getTagCountArtist() {
        return tagCountArtist;
    }

    public void setTagCountArtist(int tagCountArtist) {
        this.tagCountArtist = tagCountArtist;
    }

    public int getTagCountCharacter() {
        return tagCountCharacter;
    }

    public void setTagCountCharacter(int tagCountCharacter) {
        this.tagCountCharacter = tagCountCharacter;
    }

    public int getTagCountCopyright() {
        return tagCountCopyright;
    }

    public void setTagCountCopyright(int tagCountCopyright) {
        this.tagCountCopyright = tagCountCopyright;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public boolean isIsStatusLocked() {
        return isStatusLocked;
    }

    public void setIsStatusLocked(boolean isStatusLocked) {
        this.isStatusLocked = isStatusLocked;
    }

    public String getFavString() {
        return favString;
    }

    public void setFavString(String favString) {
        this.favString = favString;
    }

    public String getPoolString() {
        return poolString;
    }

    public void setPoolString(String poolString) {
        this.poolString = poolString;
    }

    public int getUpScore() {
        return upScore;
    }

    public void setUpScore(int upScore) {
        this.upScore = upScore;
    }

    public int getDownScore() {
        return downScore;
    }

    public void setDownScore(int downScore) {
        this.downScore = downScore;
    }

    public boolean isIsPending() {
        return isPending;
    }

    public void setIsPending(boolean isPending) {
        this.isPending = isPending;
    }

    public boolean isIsFlagged() {
        return isFlagged;
    }

    public void setIsFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getTagCount() {
        return tagCount;
    }

    public void setTagCount(int tagCount) {
        this.tagCount = tagCount;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isIsBanned() {
        return isBanned;
    }

    public void setIsBanned(boolean isBanned) {
        this.isBanned = isBanned;
    }

    public Object getPixivId() {
        return pixivId;
    }

    public void setPixivId(Object pixivId) {
        this.pixivId = pixivId;
    }

    public Object getLastCommentedAt() {
        return lastCommentedAt;
    }

    public void setLastCommentedAt(Object lastCommentedAt) {
        this.lastCommentedAt = lastCommentedAt;
    }

    public boolean isHasActiveChildren() {
        return hasActiveChildren;
    }

    public void setHasActiveChildren(boolean hasActiveChildren) {
        this.hasActiveChildren = hasActiveChildren;
    }

    public int getBitFlags() {
        return bitFlags;
    }

    public void setBitFlags(int bitFlags) {
        this.bitFlags = bitFlags;
    }

    public String getUploaderName() {
        return uploaderName;
    }

    public void setUploaderName(String uploaderName) {
        this.uploaderName = uploaderName;
    }

    public boolean isHasLarge() {
        return hasLarge;
    }

    public void setHasLarge(boolean hasLarge) {
        this.hasLarge = hasLarge;
    }

    public String getTagStringArtist() {
        return tagStringArtist;
    }

    public void setTagStringArtist(String tagStringArtist) {
        this.tagStringArtist = tagStringArtist;
    }

    public String getTagStringCharacter() {
        return tagStringCharacter;
    }

    public void setTagStringCharacter(String tagStringCharacter) {
        this.tagStringCharacter = tagStringCharacter;
    }

    public String getTagStringCopyright() {
        return tagStringCopyright;
    }

    public void setTagStringCopyright(String tagStringCopyright) {
        this.tagStringCopyright = tagStringCopyright;
    }

    public String getTagStringGeneral() {
        return tagStringGeneral;
    }

    public void setTagStringGeneral(String tagStringGeneral) {
        this.tagStringGeneral = tagStringGeneral;
    }

    public boolean isHasVisibleChildren() {
        return hasVisibleChildren;
    }

    public void setHasVisibleChildren(boolean hasVisibleChildren) {
        this.hasVisibleChildren = hasVisibleChildren;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getLargeFileUrl() {
        return largeFileUrl;
    }

    public void setLargeFileUrl(String largeFileUrl) {
        this.largeFileUrl = largeFileUrl;
    }

    public String getPreviewFileUrl() {
        return previewFileUrl;
    }

    public void setPreviewFileUrl(String previewFileUrl) {
        this.previewFileUrl = previewFileUrl;
    }
}
