/*
 * Copyright (C) 2016 dest16
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.destin.moeviewer.model.shuushuu;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShuushuuResult {
    @SerializedName("max_image_id")
    private int maxImageId;

    private List<ShuushuuPost> images;

    public int getMaxImageId() {
        return maxImageId;
    }

    public void setMaxImageId(int maxImageId) {
        this.maxImageId = maxImageId;
    }

    public List<ShuushuuPost> getImages() {
        return images;
    }

    public void setImages(List<ShuushuuPost> images) {
        this.images = images;
    }
}
