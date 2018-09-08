package com.example.mydatabase.room;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by ryan on 18-8-24.
 */

public class AppExecutors {
    private Executor mIOExcutor;

    public AppExecutors() {
        mIOExcutor = Executors.newSingleThreadExecutor();
    }

    public Executor getDiskIO(){
        return mIOExcutor;
    }

}
