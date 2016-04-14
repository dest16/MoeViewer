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

package com.destin.moeviewer.model.shuushuu;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShuushuuPost {


    /**
     * image_id : 825365
     * username : cosmictails
     * date_added : 1460614517
     * filename : 2016-04-14-825365
     * ext : jpeg
     * fullsize : 387116
     * rating : 0
     * width : 820
     * height : 1257
     * thumb_width : 130
     * thumb_height : 200
     * medium : 0
     * large : 0
     * posts : 0
     * themetags : [{"id":"2","title":"dress"},{"id":"54","title":"thigh highs"},{"id":"143","title":"smile"},{"id":"25","title":"blush"},{"id":"181","title":"black hair"},{"id":"12526","title":"brown eyes"},{"id":"720","title":"ahoge"},{"id":"63","title":"hat"},{"id":"3","title":"ribbon"},{"id":"161","title":"short hair"}]
     * artisttags : [{"id":"167178","title":"pp (Pixiv 12057619)"}]
     * sourcetags : [{"id":"161429","title":"The Idolm@ster Cinderella Girls: Starlight Stage"}]
     */

    @SerializedName("image_id")
    private int imageId;
    private String username;
    @SerializedName("date_added")
    private String dateAdded;
    private String filename;
    private String ext;
    private int fullsize;
    private int rating;
    private int width;
    private int height;
    @SerializedName("thumb_width")
    private int thumbWidth;
    @SerializedName("thumb_height")
    private int thumbHeight;
    private int medium;
    private int large;
    private int posts;
    /**
     * id : 2
     * title : dress
     */

    private List<Themetag> themetags;
    /**
     * id : 167178
     * title : pp (Pixiv 12057619)
     */

    private List<Artisttag> artisttags;
    /**
     * id : 161429
     * title : The Idolm@ster Cinderella Girls: Starlight Stage
     */

    private List<Sourcetag> sourcetags;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public int getFullsize() {
        return fullsize;
    }

    public void setFullsize(int fullsize) {
        this.fullsize = fullsize;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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

    public int getThumbWidth() {
        return thumbWidth;
    }

    public void setThumbWidth(int thumbWidth) {
        this.thumbWidth = thumbWidth;
    }

    public int getThumbHeight() {
        return thumbHeight;
    }

    public void setThumbHeight(int thumbHeight) {
        this.thumbHeight = thumbHeight;
    }

    public int getMedium() {
        return medium;
    }

    public void setMedium(int medium) {
        this.medium = medium;
    }

    public int getLarge() {
        return large;
    }

    public void setLarge(int large) {
        this.large = large;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public List<Themetag> getThemetags() {
        return themetags;
    }

    public void setThemetags(List<Themetag> themetags) {
        this.themetags = themetags;
    }

    public List<Artisttag> getArtisttags() {
        return artisttags;
    }

    public void setArtisttags(List<Artisttag> artisttags) {
        this.artisttags = artisttags;
    }

    public List<Sourcetag> getSourcetags() {
        return sourcetags;
    }

    public void setSourcetags(List<Sourcetag> sourcetags) {
        this.sourcetags = sourcetags;
    }

    public static class Themetag {
        private int id;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class Artisttag {
        private int id;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class Sourcetag {
        private int id;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
