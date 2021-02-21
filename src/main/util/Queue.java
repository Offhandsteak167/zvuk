package main.util;

import java.util.Iterator;

public interface Queue<T> {
    int size();
    void enqueue(T value);
    T dequeue();

}
