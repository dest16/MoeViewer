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

package com.destin.moeviewer.data;

import com.destin.moeviewer.BaseProvider;
import com.destin.moeviewer.model.common.Post;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;

public interface Provider extends BaseProvider {
    int POST_LIMIT = 20;

    Func1<String, Observable<String[]>> getAutoCompleteFunc();

    Func1<Integer, Observable<List<Post>>> getPostFunc();

}