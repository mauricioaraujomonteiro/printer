package com.github.mauricioaraujomonteiro.service.queue;

import java.beans.PropertyChangeListener;

public class QueueService {

    private final Queue queue;

    public QueueService() {
        this.queue = new Queue();
    }

    public void send(String message) {
        queue.add(message);
    }

    public void registerListener(PropertyChangeListener listener) {
        queue.addObserver(listener);
    }
    public String read() {
        return queue.read();
    }
}
