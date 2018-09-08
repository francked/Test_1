package com.example.mytablayout.thread;

/**
 * Created by ryan on 18-8-15.
 */

public class TestThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello World");
    }

    public static void main(String[] args){
        Thread thread = new TestThread();
        thread.start();
    }
}
