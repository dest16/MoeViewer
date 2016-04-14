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

package com.destin.moeviewer.model.mjvart;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MjvArtPost {
    /**
     * medium_preview : https://ip1.anime-pictures.net/jvwall_images/e9f/e9f9b2ee9df25d4b8230aebfb87a8419_cp.jpg
     * erotics : 0
     * small_preview : https://ip1.anime-pictures.net/jvwall_images/e9f/e9f9b2ee9df25d4b8230aebfb87a8419_sp.jpg
     * big_preview : https://ip1.anime-pictures.net/jvwall_images/e9f/e9f9b2ee9df25d4b8230aebfb87a8419_bp.jpg
     * ext : .jpeg
     * score_number : 10
     * height : 1200
     * width : 817
     * md5_pixels : 8047d283153335ea1dc62f806d83ae51
     * score : 0
     * pubtime : 4/14/16, 5:20 PM
     * download_count : 19
     * size : 476651
     * id : 474881
     * color : [114,97,94]
     * md5 : e9f9b2ee9df25d4b8230aebfb87a8419
     */

    @SerializedName("medium_preview")
    private String mediumPreview;
    private int erotics;
    @SerializedName("small_preview")
    private String smallPreview;
    @SerializedName("big_preview")
    private String bigPreview;
    private String ext;
    @SerializedName("score_number")
    private int scoreNumber;
    private int height;
    private int width;
    @SerializedName("md5_pixels")
    private String md5Pixels;
    private int score;
    private String pubtime;
    @SerializedName("download_count")
    private int downloadCount;
    private int size;
    private int id;
    private String md5;
    private List<Integer> color;

    public String getMediumPreview() {
        return mediumPreview;
    }

    public void setMediumPreview(String mediumPreview) {
        this.mediumPreview = mediumPreview;
    }

    public int getErotics() {
        return erotics;
    }

    public void setErotics(int erotics) {
        this.erotics = erotics;
    }

    public String getSmallPreview() {
        return smallPreview;
    }

    public void setSmallPreview(String smallPreview) {
        this.smallPreview = smallPreview;
    }

    public String getBigPreview() {
        return bigPreview;
    }

    public void setBigPreview(String bigPreview) {
        this.bigPreview = bigPreview;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public int getScoreNumber() {
        return scoreNumber;
    }

    public void setScoreNumber(int scoreNumber) {
        this.scoreNumber = scoreNumber;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getMd5Pixels() {
        return md5Pixels;
    }

    public void setMd5Pixels(String md5Pixels) {
        this.md5Pixels = md5Pixels;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public List<Integer> getColor() {
        return color;
    }

    public void setColor(List<Integer> color) {
        this.color = color;
    }
}
