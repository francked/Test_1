package com.example.mytablayout.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by ryan on 18-8-14.
 */

public class DrawLayout extends View {

    private int lastX;
    private int lastY;
    private Scroller scroller;

    public DrawLayout(Context context) {
        super(context);
        scroller = new Scroller(context);

    }

    public DrawLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (scroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(scroller.getCurrX(),scroller.getCurrY());
            invalidate();
        }
    }

    public void smoothScroller(int destX,int destY){
        int scrollX = getScrollX();
        int delta = destX - scrollX;
        scroller.startScroll(scrollX,0,delta,0,2000);
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //layout(getLeft()+offsetX, getTop() + offsetY, getRight() + offsetX , getBottom() + offsetY);

//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);

                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();

                layoutParams.leftMargin = getLeft() + offsetX;
                layoutParams.topMargin = getTop() + offsetY;

//                setLayoutParams(layoutParams);
                ((View)getParent()).scrollBy(-offsetX,-offsetY);

                break;
        }


        return true;
    }


}
