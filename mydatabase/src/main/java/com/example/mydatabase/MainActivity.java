package com.example.mydatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mydatabase.greendao.GreenDaoActivity;
import com.example.mydatabase.ormlite.OrmliteActivity;
import com.example.mydatabase.room.RoomActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.room).setOnClickListener(this);
        findViewById(R.id.greenDao).setOnClickListener(this);
        findViewById(R.id.ormlite).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.room:
                startActivity(new Intent(MainActivity.this,RoomActivity.class));
            case R.id.greenDao:
                startActivity(new Intent(MainActivity.this,GreenDaoActivity.class));
            case R.id.ormlite:
                startActivity(new Intent(MainActivity.this, OrmliteActivity.class));
        }
    }
}
