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

package com.destin.moeviewer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.destin.moeviewer.R;
import com.destin.moeviewer.model.common.Post;
import com.destin.moeviewer.widget.StaggeredImageView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    public List<Post> mList;

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView imageView = (ImageView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_post, parent, false);
        PostHolder holder = new PostHolder(imageView);
        return holder;
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {
        Post post = mList.get(position);
        float ratio = (float) post.getPreviewHeight() / post.getPreviewWidth();
        holder.img.setRatio(ratio);
        Glide.with(holder.itemView.getContext()).load(mList.get(position).getPreviewUrl()).into((ImageView) holder.itemView);
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    public static class PostHolder extends RecyclerView.ViewHolder {
        private StaggeredImageView img;

        public PostHolder(View itemView) {
            super(itemView);
            img = (StaggeredImageView) itemView;
        }
    }

}
