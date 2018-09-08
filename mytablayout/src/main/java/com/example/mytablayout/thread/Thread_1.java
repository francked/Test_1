package com.example.mytablayout.thread;

import android.util.Log;

/**
 * Created by ryan on 18-8-24.
 */

public class Thread_1 extends Thread {
    private static final String TAG = "Thread_1";
    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "run: 继承Thread ， 重写Thread");
    }
}
