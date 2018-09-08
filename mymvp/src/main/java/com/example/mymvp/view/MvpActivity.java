package com.example.mymvp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymvp.BaseActivity;
import com.example.mymvp.BasePresenter;
import com.example.mymvp.R;
import com.example.mymvp.presenter.MainPresenter;

public class MvpActivity extends BaseActivity implements IMainView {

    private TextView tv;
    private Button getData;
    private MainPresenter mainPresenter = new MainPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        tv = findViewById(R.id.tv);
        getData = findViewById(R.id.getData);

    }

    @Override
    public BasePresenter bindPresenter() {
        return mainPresenter;
    }

    @Override
    public void initData() {
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //presenter
                mainPresenter.fetch();
            }
        });
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_mvp;
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "正在拼命加载中。。。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showData(String data) {
        tv.setText(data);
    }
}
