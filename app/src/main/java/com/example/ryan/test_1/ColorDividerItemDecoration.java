package com.example.ryan.test_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by ryan on 18-8-13.
 */

public class ColorDividerItemDecoration extends RecyclerView.ItemDecoration {

    private static final String TAG = "ColorDividerItemDecorat";
    private float mDividerHeight;
    private Paint mPaint;
    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;
    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    private int mOrientation;

    public ColorDividerItemDecoration(int orientation) {
        mPaint = new Paint();

        mPaint.setAntiAlias(true);

        mPaint.setColor(Color.RED);

        setOrientation(orientation);
    }

    public void setOrientation(int orientation) {

        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST){
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        Log.d(TAG, "getItemOffsets: 我执行");
        if (parent.getChildAdapterPosition(view) != 0){
            outRect.top  = 10;
            mDividerHeight = 10;
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        if (mOrientation == VERTICAL_LIST){
            drawVertical(c,parent);
        }else {
            drawHorizontal(c,parent);
        }



    }

    private void drawVertical(Canvas c, RecyclerView parent) {

        Log.d(TAG, "drawVertical: 我执行");
//        int childCount = parent.getChildCount();
//        for (int i = 0; i < childCount; i++) {
//            View view = parent.getChildAt(i);
//            int index = parent.getChildAdapterPosition(view);
//            if (index == 0){
//                continue;
//            }
//            float top = view.getTop() - mDividerHeight;
//            float left = parent.getPaddingLeft();
//            float bottom = view.getTop();
//            float right = parent.getWidth() - parent.getPaddingRight();
//            c.drawRect(left,top,right,bottom,mPaint);
//        }

        final float left = parent.getPaddingLeft();

        final float right = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            final float top = child.getBottom() + params.bottomMargin;

            final float bottom = top + mDividerHeight;

            c.drawRect(left,top,right,bottom,mPaint);


        }
    }


    private void drawHorizontal(Canvas c, RecyclerView parent) {

         float top = parent.getPaddingTop();

         float bottom = parent.getHeight() - parent.getPaddingBottom();

         int childCount = parent.getChildCount();


        for (int i = 0; i < childCount; i++) {
             View child = parent.getChildAt(i);

             RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

             float left = child.getHeight() + params.rightMargin;

             float right = left + mDividerHeight;

            c.drawRect(left,top,right,bottom,mPaint);

        }
    }


}
