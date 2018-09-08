package com.example.mymvp.login.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymvp.BaseActivity;
import com.example.mymvp.BasePresenter;
import com.example.mymvp.R;
import com.example.mymvp.TextAppcation;
import com.example.mymvp.login.greendao.UserDao;
import com.example.mymvp.login.presenter.RegisterPresenter;
import com.orhanobut.logger.Logger;

public class RegisterActivity extends BaseActivity implements IRegisterView {

    private TextView name;
    private TextView pass;
    private TextView age;
    private Button register;

    private RegisterPresenter presenter = new RegisterPresenter(this,this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        name = findViewById(R.id.register_name);
        pass = findViewById(R.id.register_password);
        age = findViewById(R.id.register_age);
        register = findViewById(R.id.register);
    }

    @Override
    public BasePresenter bindPresenter() {
        return presenter;
    }

    @Override
    public void initData() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.e("我在注册界面 点击了注册按钮");
                presenter.register();
            }
        });
    }

    @Override
    public int getLayoutResId() {
        return R.layout.activity_register;
    }

    @Override
    public String getName() {
        return name.getText().toString().trim();
    }

    @Override
    public String getPass() {
        return pass.getText().toString().trim();
    }

    @Override
    public int age() {
        if (TextUtils.isEmpty(age.getText().toString().trim())){
            return 0;
        }
        return Integer.parseInt(age.getText().toString().trim());
    }

    @Override
    public void success(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                finish();

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
        });

    }
}
