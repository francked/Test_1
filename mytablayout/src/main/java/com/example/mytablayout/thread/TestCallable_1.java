package com.example.mytablayout.thread;

import android.util.Log;

import java.util.concurrent.Callable;

/**
 * Created by ryan on 18-8-24.
 */

public class TestCallable_1 implements Callable<String> {

    private static final String TAG = "TestCallable_1";
    @Override
    public String call() throws Exception {
        String s = "实现了Callable，重写了call方法，此方法会返回一个返回值，类型可以在实现Callable的泛型中设置";
        Log.d(TAG, "call: " + s);
        return s;
    }
}
