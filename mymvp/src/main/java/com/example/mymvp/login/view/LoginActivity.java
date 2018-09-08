package com.example.mymvp.login.view;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mymvp.BaseActivity;
import com.example.mymvp.BasePresenter;
import com.example.mymvp.R;
import com.example.mymvp.content.ContentActivity;
import com.example.mymvp.login.presenter.LoginPresenter;

public class LoginActivity extends BaseActivity implements ILoginView {


    private EditText edit_name;
    private EditText edit_pass;
    private Button login_bt;

    private LoginPresenter loginPresenter = new LoginPresenter(this,this);
    private Button regiset_bt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        edit_name = findViewById(R.id.edit_name);
        edit_pass = findViewById(R.id.edit_password);
        login_bt = findViewById(R.id.login);
        regiset_bt = findViewById(R.id.register_bt);
    }

    @Override
    public BasePresenter bindPresenter() {
        return loginPresenter;
    }

    @Override
    public void initData() {
        login_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login();
            }
        });

        regiset_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });


    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    public void show() {

    }

    @Override
    public String getName() {
        return edit_name.getText().toString().trim();
    }

    @Override
    public String getPass() {
        return edit_pass.getText().toString().trim();
    }

    @Override
    public void success(final String msg) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this, ContentActivity.class));
            }
        });

    }

    @Override
    public void error(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

            }
        });    }
}
