package com.example.myhandler.room;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by ryan on 18-9-7.
 */

public class AppExecutor {

    private static final int THREAD_COUNT = 3;
    private Executor mDiskIO;
    private Executor mNetWorkIO;
    private Executor mMainThread;

    public AppExecutor(Executor mDiskIO, Executor mNetWorkIO, Executor mMainThread) {
        this.mDiskIO = mDiskIO;
        this.mNetWorkIO = mNetWorkIO;
        this.mMainThread = mMainThread;
    }

    public AppExecutor() {
        this(new DiskIOThreadExector()
        , Executors.newFixedThreadPool(THREAD_COUNT)
        ,new MainThreadExcetor());
    }

    public Executor getmDiskIO() {
        return mDiskIO;
    }

    public Executor getmNetWorkIO() {
        return mNetWorkIO;
    }

    public Executor getmMainThread() {
        return mMainThread;
    }


    private static class MainThreadExcetor implements Executor{

        private Handler handler = new Handler(Looper.getMainLooper());
        @Override
        public void execute(@NonNull Runnable command) {
            handler.post(command);
        }
    }

    public static class DiskIOThreadExector implements Executor {
        private final Executor dislIO;

        public DiskIOThreadExector() {
            this.dislIO = Executors.newSingleThreadExecutor();
        }

        @Override
        public void execute(@NonNull Runnable runnable) {
            dislIO.execute(runnable);
        }
    }
}
