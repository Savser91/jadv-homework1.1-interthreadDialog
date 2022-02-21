package com.company;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task1 = new Task(15, "task1");
        Callable<Integer> task2 = new Task(30, "task2");
        Callable<Integer> task3 = new Task(39, "task3");
        Callable<Integer> task4 = new Task(28, "task4");
        ExecutorService threadPool =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<Integer>> list = new ArrayList<Callable<Integer>>();
        list.add(task1);
        list.add(task2);
        list.add(task3);
        list.add(task4);

        FutureTask<Integer> future1 = (FutureTask<Integer>) threadPool.submit(task1);
        FutureTask<Integer> future2 = (FutureTask<Integer>) threadPool.submit(task2);
        FutureTask<Integer> future3 = (FutureTask<Integer>) threadPool.submit(task3);
        FutureTask<Integer> future4 = (FutureTask<Integer>) threadPool.submit(task4);

        Integer resTask1 = future1.get();
        Integer resTask2 = future2.get();
        Integer resTask3 = future3.get();
        Integer resTask4 = future4.get();

        System.out.println("Количество напечатанных сообщений для задачи 1 - " + resTask1);
        System.out.println("Количество напечатанных сообщений для задачи 2 - " + resTask2);
        System.out.println("Количество напечатанных сообщений для задачи 3 - " + resTask3);
        System.out.println("Количество напечатанных сообщений для задачи 4 - " + resTask4);

        Integer fastestRes = threadPool.invokeAny(list);
        System.out.printf("Result of the fastest task is %s\n", fastestRes);
    }

}
