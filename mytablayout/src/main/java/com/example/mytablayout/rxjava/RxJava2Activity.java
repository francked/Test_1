package com.example.mytablayout.rxjava;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mytablayout.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class RxJava2Activity extends AppCompatActivity {

    private static final String TAG = "RxJava2Activity";
    private Subscriber<String> subscriber;
    private ImageView imageView;
    private int drawableRes;
    private Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java2);
        subscriber = new Subscriber<String>() {
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
                Log.d(TAG, "Item: "  + s);
            }
        };

        findViewById(R.id.observable).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Observable observable = Observable.create(new Observable.OnSubscribe() {
                    @Override
                    public void call(Object o) {
                        subscriber.onNext("狮子");
                        subscriber.onNext("老虎");
                        subscriber.onNext("豹子");
                        subscriber.onNext("狼");
                        subscriber.onCompleted();
                        subscriber.onNext("兔子");

                    }
                });

                observable.subscribe(subscriber);
            }
        });

        findViewById(R.id.action1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] name = {"老虎","狮子","豹子"};
                Observable.from(name)
                        .subscribe(new Action1<String>() {
                            @Override
                            public void call(String s) {
                                Log.d(TAG, "call: " + s);
                            }
                        });

            }
        });

        imageView = findViewById(R.id.image);
        drawableRes = R.drawable.mao;

        findViewById(R.id.observable_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Observable.create(new Observable.OnSubscribe<Drawable>() {
                    @Override
                    public void call(Subscriber<? super Drawable> subscriber) {
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            drawable = getTheme().getDrawable(drawableRes);
                        }
                        subscriber.onNext(drawable);
                        subscriber.onCompleted();
                    }
                }).subscribe(new Observer<Drawable>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: 结束");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(RxJava2Activity.this, "Error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(Drawable drawable) {
                        imageView.setImageDrawable(drawable);
                    }
                });
            }
        });


        findViewById(R.id.observable_main).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Observable.just(1,2,3,4).subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Action1<Integer>() {
//                            @Override
//                            public void call(Integer integer) {
//                                Log.d(TAG, "Integer: " + integer);
//
//                            }
//                        });

                Observable.create(new Observable.OnSubscribe<Drawable>() {
                    @Override
                    public void call(Subscriber<? super Drawable> subscriber) {
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                            Drawable drawable = getTheme().getDrawable(R.drawable.mao);
                            subscriber.onNext(drawable);
                            subscriber.onCompleted();
                        }
                    }
                }).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Drawable>() {
                            @Override
                            public void onCompleted() {
                                Log.d(TAG, "onCompleted: ");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(RxJava2Activity.this, "Error", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNext(Drawable drawable) {
                                imageView.setImageDrawable(drawable);
                            }
                        });



                }

        });

        findViewById(R.id.observable_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String filePath = "/sdcard/1111.png";


                Observable.just(filePath)
                        .map(new Func1<String, Bitmap>() {
                            @Override
                            public Bitmap call(String s) {
                                return getBitmapFromPath(s);
                            }
                        })
                        .subscribe(new Action1<Bitmap>() {
                            @Override
                            public void call(Bitmap bitmap) {
                                imageView.setImageBitmap(bitmap);
                            }
                        });
            }
        });

        findViewById(R.id.observable_flatMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                Student[] students = {new Student("张三",23) ,
                        new Student("李四",24),
                        new Student("王五",25),
                        new Student("赵六",26),
                        new Student("小明",27)};
//
//                Observable.from(students).map(new Func1<Student, String>() {
//                    @Override
//                    public String call(Student student) {
//                        return student.getName();
//                    }
//                }).subscribe(new Subscriber<String>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d(TAG, "onCompleted: ");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Toast.makeText(RxJava2Activity.this, "Error", Toast.LENGTH_SHORT).show();
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Log.d(TAG, "student: " + s);
//                    }
//                });

                Observable.from(students)
                        .subscribe(new Subscriber<Student>() {
                            @Override
                            public void onCompleted() {
                                Log.d(TAG, "onCompleted: ");
                            }

                            @Override
                            public void onError(Throwable e) {
                                Toast.makeText(RxJava2Activity.this, "Error", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onNext(Student student) {
                                List<Course> courses = student.getCourse();

                                courses.add(new Course("语文"));
                                courses.add(new Course("数学"));
                                courses.add(new Course("英语"));
                                courses.add(new Course("物理"));
                                courses.add(new Course("化学"));
                                courses.add(new Course("生物"));
                                courses.add(new Course("历史"));
                                courses.add(new Course("地理"));

                                for (int i = 0; i < courses.size(); i++) {
                                    Course course = courses.get(i);
                                    Log.d(TAG, "courses: " + course.getName());
                                }
                            }
                        });

            }
        });








    }


    public Bitmap getBitmapFromPath(String filePath){

        Bitmap bitmap = null;
        try {
            byte[] bytes = Base64.decode(filePath,Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
        }catch (Exception e){
           return null;
        }
        return bitmap;

    }
}
