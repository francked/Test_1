package com.example.myeventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.post1)
    public void onPost1(){
        EventBus.getDefault().post(new FirstEvent("First"));
    }
    @OnClick(R.id.post2)
    public void onPost2(){
        EventBus.getDefault().post(new SecondEvent("Second"));
    }
    @OnClick(R.id.post3)
    public void onPost3(){
        EventBus.getDefault().post(new ThirdEvent("Three"));
    }
    @OnClick(R.id.post4)
    public void onPost4(){
        EventBus.getDefault().post(new FourthEvent("Four"));
    }
}
