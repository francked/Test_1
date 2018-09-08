package com.example.mycakkback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements ChangTitle,IA {

    private static final String TAG = "MainActivity";
    private TextView tv;

    private Iserver iserver;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv = findViewById(R.id.tv);

        new MyTask(this).execute("我是标题");


        new Iserver(this).get();


        Map<String,String> map = new HashMap<>();
        map.put("张三","1");
        map.put("李四","2");
        map.put("王五","3");
        map.put("赵六","4");
        map.put("田七","5");

        String josn = new JSONObject(map).toString();
        Log.d(TAG, "onCreate: " + josn);

    }

    @Override
    public void onChangeTitle(String title) {
        tv.setText(title);
    }

    @Override
    public void getid(String s) {
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
    }
}
