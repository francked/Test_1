package com.example.mytablayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.mytablayout.eventbus.EventActivity;
import com.example.mytablayout.materialdesign.TabLayoutActivity;
import com.example.mytablayout.okhttp.OkttpssActivity;
import com.example.mytablayout.retrofit.Main3Activity;
import com.example.mytablayout.rxjava.RxJavaActivity;
import com.example.mytablayout.searchwenjian.SearchWenJianActivity;
import com.example.mytablayout.thread.ThreadActivity;
import com.example.mytablayout.view.PointActivity;
import com.example.mytablayout.view2.LayoutActivity;
import com.example.mytablayout.viewpager.ViewPagerActivity;
import com.example.mytablayout.volley.VolleyssActivity;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("手打Demo");

        findViewById(R.id.materialdesign).setOnClickListener(this);
        findViewById(R.id.view).setOnClickListener(this);
        findViewById(R.id.view2).setOnClickListener(this);
        findViewById(R.id.volley).setOnClickListener(this);
        findViewById(R.id.okhttp).setOnClickListener(this);
        findViewById(R.id.event).setOnClickListener(this);
        findViewById(R.id.viewpager).setOnClickListener(this);
        findViewById(R.id.searchWenJian).setOnClickListener(this);
        findViewById(R.id.rxJava).setOnClickListener(this);
        findViewById(R.id.retrofit).setOnClickListener(this);
        findViewById(R.id.thread).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //Material Design 的 设计风格
            case R.id.materialdesign:
                startActivity(new Intent(Main2Activity.this, TabLayoutActivity.class));

                break;

            //自定义view
            case R.id.view:
                startActivity(new Intent(Main2Activity.this, PointActivity.class));

                break;

            case R.id.view2:
                startActivity(new Intent(Main2Activity.this, LayoutActivity.class));

                break;

            //volley库
            case R.id.volley:
                startActivity(new Intent(Main2Activity.this, VolleyssActivity.class));

                break;
            case R.id.okhttp:
                startActivity(new Intent(Main2Activity.this, OkttpssActivity.class));

                break;

            case R.id.event:
                startActivity(new Intent(Main2Activity.this, EventActivity.class));

                break;
            case R.id.viewpager:
                startActivity(new Intent(Main2Activity.this, ViewPagerActivity.class));

                break;
            case R.id.searchWenJian:
                startActivity(new Intent(Main2Activity.this, SearchWenJianActivity.class));

                break;
            case R.id.rxJava:
                startActivity(new Intent(Main2Activity.this, RxJavaActivity.class));

                break;

            case R.id.retrofit:
                startActivity(new Intent(Main2Activity.this, Main3Activity.class));

                break;
            case R.id.thread:
                startActivity(new Intent(Main2Activity.this, ThreadActivity.class));

                break;
        }
    }
}
