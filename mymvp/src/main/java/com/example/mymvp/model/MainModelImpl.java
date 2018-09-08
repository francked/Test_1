package com.example.mymvp.model;

/**
 * Created by ryan on 18-8-28.
 */

public class MainModelImpl implements IMainModel {


    @Override
    public void loadData(OnLoadCompleteListener listener) {

        String data = "我是从本地加载来的数据";
        listener.onComplete(data);

    }
}
