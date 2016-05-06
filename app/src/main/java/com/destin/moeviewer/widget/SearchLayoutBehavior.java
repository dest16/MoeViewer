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

package com.destin.moeviewer.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

import com.destin.sehaikun.AnimationUtils;

/**
 * Created by dest1 on 2015/11/11.
 */
public class SearchLayoutBehavior extends CoordinatorLayout.Behavior<View> {
    private boolean animating;
    private int dyChangeSum = 0;

    public SearchLayoutBehavior(Context context, AttributeSet attrs) {
        super();
    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL && child.isEnabled();
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        if (dyConsumed >= 0 && child.getVisibility() == View.VISIBLE)
            dyChangeSum += dyConsumed;
        else if (dyConsumed < 0)
            dyChangeSum = 0;
        if (dyChangeSum >= child.getHeight() && child.getVisibility() == View.VISIBLE && !animating) {
            hide(child);
        } else if (dyConsumed < 0 && child.getVisibility() == View.GONE && !animating) {
            show(child);
        }
    }


    void hide(final View view) {
        view.animate().translationY(-view.getHeight()).setInterpolator(AnimationUtils.FAST_SLOW_INTERPOLATOR).setDuration(200)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        animating = true;
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        view.setVisibility(View.GONE);
                        animating = false;
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {
                        show(view);
                    }

                });

    }

    void show(final View view) {
        view.animate().translationY(0).setInterpolator(AnimationUtils.FAST_SLOW_INTERPOLATOR).setDuration(200)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        view.setVisibility(View.VISIBLE);
                        animating = true;
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        animating = false;
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {
                        hide(view);
                    }

                });
    }
}
