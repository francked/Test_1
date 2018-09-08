package com.example.mytablayout.thread;

import android.util.Log;

/**
 * Created by ryan on 18-8-24.
 */

public class Runnable_1 implements Runnable {
    private static final String TAG = "Runnable_1";
    private int i  = 0;

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()){
            i++;
            Log.d(TAG, "i: " + i);
        }

        Log.d(TAG, "此时 stop" );

        Log.d(TAG, "run: 这里是实现Runnable， 重写了run（）方法");
    }
}
