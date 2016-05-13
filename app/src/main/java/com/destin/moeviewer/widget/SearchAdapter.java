/*
 *Copyright 2015 Miguel Catalan Bañuls
 *
 *Licensed under the Apache License, Version 2.0 (the "License");
 *you may not use this file except in compliance with the License.
 *You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing, software
 *distributed under the License is distributed on an "AS IS" BASIS,
 *WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *See the License for the specific language governing permissions and
 *limitations under the License.
 */

package com.destin.moeviewer.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.destin.moeviewer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * a fork of com.miguelcatalan.materialsearchview
 */
public class SearchAdapter extends BaseAdapter implements Filterable {

    private ArrayList<String> data;
    private String[] suggestions;
    private Drawable suggestionIcon;
    private LayoutInflater inflater;
    private boolean ellipsize;

    public SearchAdapter(Context context, String[] suggestions) {
        inflater = LayoutInflater.from(context);
        data = new ArrayList<>();
        this.suggestions = suggestions;
    }

    public SearchAdapter(Context context, String[] suggestions, Drawable suggestionIcon, boolean ellipsize) {
        inflater = LayoutInflater.from(context);
        data = new ArrayList<>();
        this.suggestions = suggestions;
        this.suggestionIcon = suggestionIcon;
        this.ellipsize = ellipsize;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (!TextUtils.isEmpty(constraint)) {

                    // Retrieve the autocomplete results.
                    List<String> searchData = new ArrayList<>();

                    for (String string : suggestions) {
                        if (string.toLowerCase().startsWith(constraint.toString().toLowerCase())) {
                            searchData.add(string);
                        }
                    }

                    // Assign the data to the FilterResults
                    filterResults.values = searchData;
                    filterResults.count = searchData.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results.values != null) {
                    data = (ArrayList<String>) results.values;
                    notifyDataSetChanged();
                }
            }
        };
        return filter;
    }

   public void setArray(String[] array){
       this.suggestions=array;
       notifyDataSetChanged();
   }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SuggestionsViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_search_suggest, parent, false);
            viewHolder = new SuggestionsViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (SuggestionsViewHolder) convertView.getTag();
        }

        String currentListData = (String) getItem(position);

        viewHolder.textView.setText(currentListData);
        if (ellipsize) {
            viewHolder.textView.setSingleLine();
            viewHolder.textView.setEllipsize(TextUtils.TruncateAt.END);
        }

        return convertView;
    }

    private class SuggestionsViewHolder {

        TextView textView;
        ImageView imageView;

        public SuggestionsViewHolder(View convertView) {
            textView = (TextView) convertView.findViewById(R.id.suggestion_text);
            if (suggestionIcon != null) {
                imageView = (ImageView) convertView.findViewById(R.id.suggestion_icon);
                imageView.setImageDrawable(suggestionIcon);
            }
        }
    }
}