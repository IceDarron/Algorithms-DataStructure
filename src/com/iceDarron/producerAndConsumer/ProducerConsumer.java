package com.iceDarron.producerAndConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 生产者消费者模式：使用Object.wait() / notify()方法实现
 */
public class ProducerConsumer {
    private static final int CAPACITY = 5;

    public static void main(String args[]) {
        Queue<Integer> queue = new LinkedList<Integer>();

        Producer producer1 = new Producer("P-1", queue, CAPACITY);
        Producer producer2 = new Producer("P-2", queue, CAPACITY);
        Consumer consumer1 = new Consumer("C1", queue, CAPACITY);
        Consumer consumer2 = new Consumer("C2", queue, CAPACITY);
        Consumer consumer3 = new Consumer("C3", queue, CAPACITY);


//        Thread thread1 = new Thread(producer1);
//        thread1.start();
//        Thread thread2 = new Thread(producer2);
//        thread2.start();
//        Thread thread3 = new Thread(consumer1);
//        thread3.start();
//        Thread thread4 = new Thread(consumer2);
//        thread4.start();
//        Thread thread5 = new Thread(consumer3);
//        thread5.start();


        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        executor.execute(producer1);
        executor.execute(producer2);
        executor.execute(consumer1);
        executor.execute(consumer2);
        executor.execute(consumer3);
    }
}
