package main.util;

public interface Queue<T> {
    int size();
    void enqueue(T value);
    T dequeue();

}
