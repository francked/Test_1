package com.example.myinterceptor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myinterceptor.ToastUtil.LogUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);

        findViewById(R.id.request).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GankPresenter.getSpecifyGanHuo("福利", 1, new RetorfitListener<List<GanHuo>>() {
                    @Override
                    public void onSuccess(List<GanHuo> data) {
                        LogUtils.d("type为福利 : \n", data.toString());
                        tv.setText(data.toString());
                    }

                    @Override
                    public void onError(String description) {
                        LogUtils.d("type为福利 : \n", "获取数据失败");
                    }
                });
            }
        });
        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String path = null;
                        try {
                            path = FileUtil.getSDcardPath();
                            File file = new File(path, FileUtil.EXTERNAL_DIRECTORY_NAME);
                            FileUtil.deleteFile(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });

        findViewById(R.id.meizhi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MeiZhiActivity.class));
            }
        });

        findViewById(R.id.swipe_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SwipeRefreshActivity.class));
            }
        });

    }
}
