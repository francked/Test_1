package com.example.myswpie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

public class Main3Activity extends AppCompatActivity {

    private Button bt_message;
    private TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        bt_message = findViewById(R.id.bt_message);
        tv_message = findViewById(R.id.tv_message);

        bt_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("你关注了我，我请你吃槟榔"));
                finish();
            }
        });
    }
}
