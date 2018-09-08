package com.example.mytablayout.eventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mytablayout.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventActivity extends AppCompatActivity {

    private TextView tv_message;
    private Button message_bt;
    private Button subscription_bt;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        tv_message = findViewById(R.id.tv_message);
        message_bt = findViewById(R.id.bt_message);
        subscription_bt = findViewById(R.id.bt_subscription);

        tv_message.setText("EventActivity");

        subscription_bt.setText("注册事件");

        message_bt.setText("跳转到SecondActivity");

        message_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventActivity.this,SecondActivity.class));
            }
        });

        subscription_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    EventBus.getDefault().register(EventActivity.this);
                    flag = false;
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag = true;
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void onMoonEvent(MessageEvent messageEvent){
        tv_message.setText(messageEvent.getMessage());
    }


}
