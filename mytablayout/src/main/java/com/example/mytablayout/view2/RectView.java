package com.example.mytablayout.view2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.mytablayout.R;

/**
 * Created by ryan on 18-8-23.
 */

public class RectView extends View {
//    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint mPaint = new Paint();
    private int mColor = Color.RED;

    public RectView(Context context) {
        super(context);
        initDraw();
    }

    public RectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RectView1);

        //提取RectView属性集合的 rect_color属性,如果没有设置，默认值为Color.Red

        mColor = a.getColor(R.styleable.RectView1_rect_color,Color.RED);

        //获取资源后要及时回收
        a.recycle();
        initDraw();
    }

    public RectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDraw();
    }

    private void initDraw() {
        mPaint.setColor(mColor);
        mPaint.setStrokeWidth((float) 2.5);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();


        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;
        canvas.drawRect(paddingLeft,paddingTop,width + paddingLeft,height + paddingTop,mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int higthSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && higthSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(600,600);
        }else if(widthSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(600,heightSpecSize);
        }else if (higthSpecMode == MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSpecSize,600);
        }



    }
}
