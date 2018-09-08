package com.example.myinterceptor;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by ryan on 18-9-1.
 */

public class SalceImage extends ImageView{


    private int originWidth;
    private int originHeight;

    public SalceImage(Context context) {
        super(context);
    }

    public SalceImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SalceImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array =  context.obtainStyledAttributes(attrs,R.styleable.ScaleImageView);
        originWidth = array.getInteger(R.styleable.ScaleImageView_origin_width,0);
        originHeight = array.getInteger(R.styleable.ScaleImageView_origin_height,0);

        array.recycle();
    }

    public void setOriginSize(int originWidth, int originHeight){
        this.originWidth = originWidth;
        this.originHeight = originHeight;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (originWidth > 0  && originHeight>0){
            float scale = originWidth * 1.0f /originHeight;
            if (scale < 0.7f){
                scale = 0.7f;
            }else if (scale > 1.3f){
                scale = 1.3f;
            }

            int width = MeasureSpec.getSize(widthMeasureSpec);
            int height = MeasureSpec.getSize(heightMeasureSpec);

            if (width > 0){
                height = (int) (width * 1.0f / scale);
            }

            setMeasuredDimension(width,height);
        }else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        }
    }
}
