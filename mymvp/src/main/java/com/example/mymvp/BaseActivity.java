package com.example.mymvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mymvp.login.greendao.UserDao;

/**
 * Created by ryan on 18-8-28.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private BasePresenter presenter = null;
    public Context context;
    public UserDao userDao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        context = this;
        userDao = TextAppcation.getInstance().getmDaoSession().getUserDao();

        presenter = bindPresenter();

        initView();

        initData();
    }

    protected abstract void initView();

    public abstract BasePresenter bindPresenter();

    public abstract void initData();


    public abstract int getLayoutResId();


    /**
     * 如果重写了此方法，一定要调用super.onDestroy();
     */

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.onDestroy();
            presenter = null;
            System.gc();
        }
    }
}
