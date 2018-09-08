package com.example.mytablayout.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by ryan on 18-8-15.
 */

public class StopThread {

    public static void main(String[] args) throws InterruptedException {
        MoonRunner moonRunner = new MoonRunner();

        Thread thread = new Thread(moonRunner,"MoonRunner");
        thread.start();

        TimeUnit.MILLISECONDS.sleep(10);
        moonRunner.cancel();
    }

    public static class MoonRunner implements Runnable{

        private long i;
        private volatile boolean on = true;

        @Override
        public void run() {
            while (on){
                i++;
                System.out.println("i = " + i);
            }
        }
        public void cancel(){
            on = false;
            System.out.println("停止");
        }
    }
}
