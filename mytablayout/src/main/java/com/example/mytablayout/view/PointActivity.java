package com.example.mytablayout.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.mytablayout.R;

public class PointActivity extends AppCompatActivity {

    private static final String TAG = "PointActivity";
    private int lastX;
    private int lastY;
    private MyView myView;
    private Boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

        DrawLayout drawLayout = new DrawLayout(this) ;

        //drawLayout.smoothScroller(-400,0);

        Button button = findViewById(R.id.btn);

        myView = new MyView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag) {
                    ObjectAnimator.ofInt(myView, "width", 600).setDuration(500).start();
                    ObjectAnimator.ofInt(myView, "Height", 400).setDuration(500).start();
                    flag = false;
                }else {
                    ObjectAnimator.ofInt(myView, "width", 200).setDuration(500).start();
                    ObjectAnimator.ofInt(myView, "Height", 100).setDuration(500).start();
                    flag = true;

                }

            }
        });


        ObjectAnimator animator1 = ObjectAnimator.ofFloat(myView,"translationX",0.0f,200.0f,0f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(myView,"scaleX",1.0f,2.0f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(myView,"rotationX",0.0f,90.0f,0.0f);


        AnimatorSet set = new AnimatorSet();

        set.setDuration(1000);

        set.play(animator1).with(animator2).after(animator3);
        set.start();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int y = (int) event.getY();
        int  x = (int) event.getX();

        float rawX = event.getRawX();
        float rawY = event.getRawY();

        Log.d(TAG, "getX: " + x + " getY: " + y);
        Log.d(TAG, "rawX: " + rawX + " rawY: " + rawY);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;
        }


        return super.onTouchEvent(event);

    }

    private static class MyView{
        private View mTarget;

        public MyView(View mTarget) {
            this.mTarget = mTarget;
        }

        public int getWidth(){
            return mTarget.getLayoutParams().width;
        }

        public void setWidth(int width){
            mTarget.getLayoutParams().width = width;
            mTarget.requestLayout();
        }

        public int getHeight(){
            return mTarget.getLayoutParams().height;
        }

        public void setHeight(int height){
            mTarget.getLayoutParams().height = height;
            mTarget.requestLayout();
        }


    }

}
