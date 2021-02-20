package main;

import java.util.Iterator;

public interface Queue<T> extends Iterator<T> {
    int size();
    void enqueue(T value);
    T dequeue();

}
