package com.example.mymvp.login.model;

/**
 * Created by ryan on 18-8-28.
 */

public  interface Imodel {

    void login(String name,String pass,OnLoginListener listener);

    void register(String name , String pass ,int age, OnRegisterListener listener);

    interface OnLoginListener{
        void success(String msg);
        void error(String msg);

    }
    interface OnRegisterListener{
        void success(String msg);
        void error(String msg);

    }
}
