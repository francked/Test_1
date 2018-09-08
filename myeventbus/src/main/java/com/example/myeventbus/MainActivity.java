package com.example.myeventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //字体缩放比例
        Log.d(TAG, "onCreate: " + getBaseContext().getResources().getDisplayMetrics().scaledDensity);

        EventBus.getDefault().register(this);

        tv = findViewById(R.id.tv_1);


        findViewById(R.id.b2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
        findViewById(R.id.b3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main3Activity.class));

            }
        });


    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(FirstEvent user){
        Log.d(TAG, "onEvent: " + user.getName());

    }
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEvent(SecondEvent user){
        Log.d(TAG, "onEvent: " + user.getName());

    }
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEvent(ThirdEvent user){
        Log.d(TAG, "onEvent: " + user.getName());

    }
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEvent(FourthEvent user){
        Log.d(TAG, "onEvent: " + user.getName());

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
