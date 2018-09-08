package com.example.mytablayout.thread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mytablayout.R;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadActivity extends AppCompatActivity {
    private static final String TAG = "ThreadActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        findViewById(R.id.thread_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread_1 thread1 = new Thread_1();
                new Thread(thread1).start();
            }
        });
        findViewById(R.id.runnable_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable_1 runnable1 = new Runnable_1();
                new Thread(runnable1).start();
            }
        });

        findViewById(R.id.callable_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestCallable_1 testCallable1 = new TestCallable_1();
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                Future future = executorService.submit(testCallable1);


                //等待线程结束，并返回结果
                try {
                    Log.d(TAG, "onClick: " + future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.obtain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable_1 runnable1 = new Runnable_1();
                Thread thread = new Thread(runnable1);
                thread.start();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                    thread.interrupt();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
