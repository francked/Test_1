package com.example.mytablayout.view2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mytablayout.R;
import com.orhanobut.logger.Logger;


public class LayoutActivity extends AppCompatActivity {


    private RelativeLayout relativeLayout;
    private TitleBar titleBar;
    private ListView lv_two;
    private ListView lv_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

       // relativeLayout = findViewById(R.id.viewGroup);

     //   InvalidTextView textView = findViewById(R.id.iv_text);
        //textView.setText("皇家马德里 C罗")

//        titleBar = findViewById(R.id.title);
//
//
//        titleBar.setLeftListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(LayoutActivity.this, "点击左键", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        titleBar.setRightListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(LayoutActivity.this, "点击右键", Toast.LENGTH_SHORT).show();
//            }
//        });

        lv_one = findViewById(R.id.lv_one);
        lv_two = findViewById(R.id.lv_two);

        String[] strs1 = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25"
                ,"26"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,strs1);
        lv_one.setAdapter(adapter);

        String[] strs2 = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N"};

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
                this,android.R.layout.simple_expandable_list_item_1,strs2);

        lv_two.setAdapter(adapter2);

    }





}
