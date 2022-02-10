package com.github.mauricioaraujomonteiro.component1;

import java.util.concurrent.ArrayBlockingQueue;

public class QueueService {

    private final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

    public void add(String message) {
        queue.add(message);
    }

    public String read() {
       return  queue.poll();
    }
}
