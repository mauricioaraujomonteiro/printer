package com.github.mauricioaraujomonteiro.service.queue;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Queue {

    private final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    private PropertyChangeSupport propertyChangeEvent = new PropertyChangeSupport (this);

    public void addObserver(PropertyChangeListener propertyChangeListener) {
        propertyChangeEvent.addPropertyChangeListener("queue", propertyChangeListener);

    }


    public void add(String message) {
        queue.add(message);
        propertyChangeEvent.firePropertyChange("queue", "", "add");

    }
    public String read() {
        return  queue.poll();
    }
}
