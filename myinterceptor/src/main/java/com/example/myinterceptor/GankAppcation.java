package com.example.myinterceptor;

import android.app.Application;

/**
 * Created by ryan on 18-8-31.
 */

public class GankAppcation extends Application {
    private static GankAppcation mInstance ;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

    }

    public static GankAppcation getmInstance(){
        return mInstance;
    }
}
