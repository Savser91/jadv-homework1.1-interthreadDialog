package com.company;

import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("Group1");
        Thread thread1 = new MyThread(threadGroup, "thread1");
        Thread thread2 = new MyThread(threadGroup, "thread2");
        Thread thread3 = new MyThread(threadGroup, "thread3");
        Thread thread4 = new MyThread(threadGroup, "thread4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.currentThread().sleep(10000);
        threadGroup.interrupt();
        System.out.println("Main thread has ended");
    }

}
