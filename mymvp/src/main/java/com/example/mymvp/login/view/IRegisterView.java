package com.example.mymvp.login.view;

/**
 * Created by ryan on 18-8-29.
 */

public interface IRegisterView {

    String getName();
    String getPass();
    int age();
    void success(String msg);
    void error(String msg);


}
