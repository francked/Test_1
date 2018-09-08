package com.example.mytablayout.view2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mytablayout.R;

/**
 * Created by ryan on 18-8-23.
 */

public class TitleBar extends RelativeLayout {


    private ImageView imageView_left;
    private TextView textView;
    private ImageView imageView_right;
    private RelativeLayout relativeLayout;

    private int mColor = Color.BLUE;
    private int mTextColor = Color.WHITE;
    private String titleName;


    public TitleBar(Context context) {
        super(context);
        initDraw(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.TitleBar);

        mColor = array.getColor(R.styleable.TitleBar_title_bg,Color.BLUE);

        mTextColor = array.getColor(R.styleable.TitleBar_title_text_color,Color.WHITE);

        titleName = array.getString(R.styleable.TitleBar_title_text);

        array.recycle();

        initDraw(context);

    }


    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDraw(context);

    }



    private void initDraw(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_customtitle,this,true);

        imageView_left = findViewById(R.id.iv_titleBar_left);
        textView = findViewById(R.id.iv_titleBar_title);
        imageView_right = findViewById(R.id.iv_titleBar_right);

        relativeLayout = findViewById(R.id.titlebar_rootlayout);

        //设置背景颜色
        relativeLayout.setBackgroundColor(mColor);

        //设置文字颜色
        textView.setTextColor(mTextColor);

        textView.setText(titleName);

    }

    public void setTitle(String titleName){
        if (!TextUtils.isEmpty(titleName)){
            textView.setText(titleName);
        }
    }

    public void setLeftListener(OnClickListener onClickListener){
        imageView_left.setOnClickListener(onClickListener);
    }

    public void setRightListener(OnClickListener onClickListener){
        imageView_right.setOnClickListener(onClickListener);
    }


}
