package com.example.mytablayout.rxjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mytablayout.R;


import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;


public class RxJavaActivity extends AppCompatActivity {

    private Observable observable;
    private Observer<String> observer;
    private Subscriber subscriber;
    private static final String TAG = "RxJavaActivity";
    private Observable observable1;
    private Observable<Long> mObserveable;
    private Subscription ms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);



        //创建观察者 他决定事物触发的时候将要有怎样的行为
        //事件列队完结
        //事件队列异常
        //普通事件
        //他会在事件还未发送之前被调用，可以用于做一些准备工作
        subscriber = new Subscriber() {

            //事件列队完结
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            //事件队列异常
            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            //普通事件
            @Override
            public void onNext(Object o) {
                Log.d(TAG, "onNext t: " + o);
            }

            //他会在事件还未发送之前被调用，可以用于做一些准备工作
            @Override
            public void onStart() {
                super.onStart();
                Log.d(TAG, "onStart: ");
            }
        };

        //observe 是一个接口 实现简单的功能，可以用它来创建观察者，subscribe实在observe的基础上进行扩展的
        observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + s);
            }
        };

        //创建被观察者 使用了 create方法来创建一个Observable 并为它定义事件触发的规则

        observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super  String> subscriber1) {
                     subscriber1.onNext("1");
                     subscriber1.onNext("2");
                     subscriber1.onNext("3");
            }
        });

        observable1 = Observable.just("1","2","3","4");


        mObserveable = Observable.interval(3, TimeUnit.SECONDS);



        findViewById(R.id.rxJava_bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                observable1.subscribe(subscriber);
                ms = mObserveable.subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d(TAG, "onNext: aLong" + aLong);
                    }
                });
//                Observable.interval(3, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
//                    @Override
//                    public void call(Long aLong) {
//                        Log.d(TAG, "interval : " + aLong.intValue() );
//                    }
//                });

            }
        });

        findViewById(R.id.rxJava_unSubscriber).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                observable1.subscribe(subscriber);
//                if (!ms.isUnsubscribed()){
//                    ms.unsubscribe();
//                }
                startActivity(new Intent(RxJavaActivity.this,RxJava2Activity.class));

            }
        });

    }
}
