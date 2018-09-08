package com.example.mytablayout.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mytablayout.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button bt = findViewById(R.id.bt_message_second);

        TextView tv = findViewById(R.id.tv_message_second);

        bt.setText("发送事件");

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EventBus.getDefault().post(new MessageEvent("欢迎关注刘望舒的博客"));
                EventBus.getDefault().postSticky(new MessageEvent("欢迎关注刘望舒的博客"));
                finish();
            }
        });



    }
}
