package com.company;

public class MyThread extends Thread{
    public MyThread(ThreadGroup g, String name) {
        super(g, name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2000);
                System.out.println("Я поток " + Thread.currentThread().getName() +  ". Всем привет!");
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("%s завершен\n", getName());
        }
    }
}
