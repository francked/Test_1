package com.example.mymvp.model;

/**
 * Created by ryan on 18-8-28.
 */

public interface IMainModel {
    void loadData(OnLoadCompleteListener listener);


    interface OnLoadCompleteListener {
        void onComplete(String data);
    }
}
