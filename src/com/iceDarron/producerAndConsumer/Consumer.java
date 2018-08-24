package com.iceDarron.producerAndConsumer;

import java.util.Queue;
import java.util.Random;

/**
 * 消费者
 */
public class Consumer implements Runnable{
    private Queue<Integer> queue;
    String name;
    int maxSize;

    public Consumer(String name, Queue<Integer> queue, int maxSize){
        this.name = name;
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run(){
        while(true){
            synchronized(queue){
                while(queue.isEmpty()){
                    try {
                        System.out.println("Queue is empty, Consumer[" + name + "] thread is waiting for Producer");
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                int x = queue.poll();
                System.out.println("[" + name + "] Consuming value : " + x);
                queue.notifyAll();

                try {
                    Thread.sleep(new Random().nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
