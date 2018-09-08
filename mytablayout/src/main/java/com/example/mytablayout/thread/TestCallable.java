package com.example.mytablayout.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by ryan on 18-8-15.
 */

public class TestCallable {
    public static class MyTestCallable implements Callable {

        @Override
        public String call() throws Exception {
            return "Hello World";
        }
    }

    public static void main(String[] args){
        MyTestCallable myTestCallable = new MyTestCallable();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future future = executorService.submit(myTestCallable);

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
