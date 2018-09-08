package com.example.mytablayout.view2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by ryan on 18-8-23.
 */

@SuppressLint("AppCompatCustomView")
public class InvalidTextView extends TextView{

    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public InvalidTextView(Context context, Paint mPaint) {
        super(context);
        initDraw();
    }

    public InvalidTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initDraw();
    }

    public InvalidTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDraw();
    }

    private void initDraw() {
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth((float) 1.5);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.drawLine(0,height/2,width,height/2,mPaint);
    }
}
