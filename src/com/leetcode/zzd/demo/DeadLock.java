package com.leetcode.zzd.demo;


import sun.misc.Lock;

/**
 * @author: zhendong.Z
 * @date: 2021-03-30 下午2:39
 */
public class DeadLockThread extends Thread{


    private final Lock lock1;
    private final Lock lock2;

    public DeadLockThread deadLock(Lock lock1, Lock lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
       synchronized (lock1){
           try {
               Thread.sleep(5000);
               System.out.println(Thread.currentThread().getName()+ "先拿" + lock1.);
           }
       }
    }
}
