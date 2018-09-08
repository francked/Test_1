package com.example.mytablayout.view2;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.orhanobut.logger.Logger;

/**
 * Created by ryan on 18-8-23.
 */

public class CustomView_2 extends View {

    private int firstX;
    private int firstY;
    public CustomView_2(Context context) {
        super(context);
    }

    public CustomView_2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView_2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {



        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                firstX = x;
                firstY = y;
                Logger.e("firstX = " + firstX + "\n firstY = " + firstY ,"");
                break;
            case MotionEvent.ACTION_MOVE:
                //当前坐标点减去起始坐标点（按下坐标点） 得到 偏移距离
                int offsetX = x - firstX;
                int offsetY = y - firstY;

                //调用layout方法来重新放置它的位置
                layout(getLeft()+offsetX,getTop()+offsetY,getRight() + offsetX, getBottom()+ offsetY);

                break;
        }


        return true;
    }



}
