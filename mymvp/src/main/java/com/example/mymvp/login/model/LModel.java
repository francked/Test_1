package com.example.mymvp.login.model;

import android.text.TextUtils;
import android.util.Log;

import com.example.mymvp.TextAppcation;
import com.example.mymvp.login.greendao.User;
import com.example.mymvp.login.greendao.UserDao;
import com.orhanobut.logger.Logger;

import java.util.List;

/**
 * Created by ryan on 18-8-28.
 */

public class LModel implements Imodel {

    private static final String TAG = "LModel";
    UserDao userDao = TextAppcation.getInstance().getmDaoSession().getUserDao();

    @Override
    public void login(final String name, final String pass, final OnLoginListener listener) {


        new Thread(new Runnable() {
            @Override
            public void run() {

                List<User> users = userDao.queryBuilder().where(UserDao.Properties.Name.eq(name)).build().list();
                if (users.isEmpty()){
                    listener.error("账号不存在，请注册");
                }else {
                    Logger.e("pass" +users.get(0).getPass() );
                    Logger.e("name" +users.get(0).getName() );
                    if (users.get(0).getPass().equals(pass)  && users.get(0).getName().equals(name) ){
                        listener.success("登录成功");
                    }else {
                        listener.error("账号密码错误");
                    }
                }

            }
        }).start();


    }

    //注册
    @Override
    public void register(final String name, final String pass, final int age, final OnRegisterListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //把数据放入数据库中  greedDao中
                //第一步 判断输入的数据是否能在数据库中查到
                List<User> users = userDao.queryBuilder().where(UserDao.Properties.Name.eq(name)).build().list();

                if (!name.equals("")|| !TextUtils.isEmpty(name) || !pass.equals("")|| !TextUtils.isEmpty(pass) ) {
                    if (users.isEmpty()) {
                        User user = new User(null,name,pass,age);
                        userDao.insert(user);
                        listener.success("注册账号成功");
                        Logger.e("成功");

                    } else {
                        listener.error("已存在注册的账号");
                        Logger.e("已存在注册的账号");

                    }
                }else {
                    listener.error("账号 或 密码 或 年龄 不能为空");
                    Logger.e("账号 或 密码 或 年龄 不能为空");

                }
            }
        }).start();
    }
}
