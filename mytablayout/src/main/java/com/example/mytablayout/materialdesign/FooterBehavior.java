package com.example.mytablayout.materialdesign;

import android.animation.Animator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;

/**
 * Created by ryan on 18-8-14.
 */

public class FooterBehavior extends CoordinatorLayout.Behavior<View> {
    private static final String TAG = "FooterBehavior";
    private int directionChange;

    public FooterBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return (type & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        if (dy > 0 && directionChange < 0 || dy < 0 && directionChange > 0){
            child.animate().cancel();
            directionChange = 0;
        }
        directionChange += dy;


        if (directionChange > child.getHeight() && child.getVisibility() == View.VISIBLE){
            hide(child);
        }else if (directionChange < 0 && child.getVisibility() == View.GONE){
            show(child);
        }

        Log.d(TAG, "onNestedPreScroll: " + child.getHeight());
    }

    private void hide(final View child) {
        ViewPropertyAnimator animator = child.animate().translationY(child.getHeight()).setInterpolator(new FastOutSlowInInterpolator())
                .setDuration(200);

        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                child.setVisibility(View.GONE);

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();

    }

    private void show(final View child) {
        ViewPropertyAnimator animator = child.animate().translationY(0).setInterpolator(new FastOutSlowInInterpolator()).setDuration(200);
        animator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                child.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();
    }
}
