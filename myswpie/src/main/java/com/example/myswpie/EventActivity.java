package com.example.myswpie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventActivity extends AppCompatActivity {

    private static final String TAG = "EventActivity";
    private Button message;
    private Button subscription;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        message = findViewById(R.id.message);
        subscription = findViewById(R.id.subscription);
        tv = findViewById(R.id.tv);

        tv.setText("EventActivity");

        message.setText("跳转到secondActivity");

        subscription.setText("注册事件");

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventActivity.this,Main3Activity.class));
            }
        });

        findViewById(R.id.bt_recyclerView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventActivity.this,MainActivity.class));

            }
        });

        findViewById(R.id.bt_event2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventActivity.this,Event2Activity.class));

            }
        });

        subscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().register(EventActivity.this);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
        EventBus.getDefault().unregister(this);
    }

    //事件订阅者处理事件
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(MessageEvent messageEvent){
        tv.setText(messageEvent.getMessage());
    }
}
