package com.company;

import java.util.concurrent.Callable;

public class Task implements Callable<Integer> {
    private int messageNumber;
    private final int PAUSE = 20;
    private String name;

    public Task(int messageNumber, String taskName) {
        this.messageNumber = messageNumber;
        this.name = taskName;
    }

    @Override
    public Integer call() throws InterruptedException {
        Thread.currentThread().setName("Thread of " + name);
        int messageCounter = 0;
        for (int i = 0; i < messageNumber; i++) {
            Thread.sleep(PAUSE);
            System.out.printf("Hello! I'm %s\n", Thread.currentThread().getName());
            messageCounter++;
        }
        return messageCounter;
    }
}
