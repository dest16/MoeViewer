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
import android.widget.TextView;

import com.destin.moeviewer.R;
import com.destin.moeviewer.data.Post;
import com.destin.moeviewer.widget.StaggeredImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    public List<Post> mList;

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_post, parent, false);
        PostHolder holder = new PostHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {
        Post post = mList.get(position);
        holder.image.setRatio(post.getRatio());
        holder.desc.setText(post.getDesc());
//        Glide.with(holder.itemView.getContext()).load(mList.get(position).getPreviewUrl()).into(holder.image);
        Picasso.with(holder.itemView.getContext()).load(mList.get(position).getPreUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        if (mList == null)
            return 0;
        return mList.size();
    }

    public static class PostHolder extends RecyclerView.ViewHolder {
        StaggeredImageView image;
        TextView desc;

        public PostHolder(View itemView) {
            super(itemView);
            image = (StaggeredImageView) itemView.findViewById(R.id.image_item_grid);
            desc = (TextView) itemView.findViewById(R.id.desc_item_grid);
        }
    }

}
