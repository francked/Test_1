package com.example.mytablayout.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ryan on 18-8-24.
 */

public class Alipay {
    private double[] accounts;
    private Lock alipaylock;
    private Condition condition;

    public Alipay(int n,double money){
        accounts = new double[n];
        alipaylock = new ReentrantLock();

        //得到条件对象
        condition = alipaylock.newCondition();
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = money;
        }
    }

    public void transfer(int from, int to,int amount) throws InterruptedException{
        alipaylock.lock();

        try {
            while (accounts[from] < amount){

                //阻塞当前线程，并放弃锁
                condition.await();
                accounts[from] = accounts[from] - amount;
                accounts[to] = accounts[to] + amount;
                condition.signalAll();
            }
        }finally {
            alipaylock.unlock();
        }
      
    }
}
