package main.util.queue;

import java.io.Serializable;

public interface Queue<T> extends Serializable {
    int size();
    void enqueue(T value);
    T dequeue();

}
