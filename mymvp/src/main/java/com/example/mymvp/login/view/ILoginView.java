package com.example.mymvp.login.view;

/**
 * Created by ryan on 18-8-28.
 */

public interface ILoginView {


    void show();

    String getName();
    String getPass();

    void success(String msg);
    void error(String msg);

}
