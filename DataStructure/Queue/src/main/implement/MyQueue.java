package main.implement;

public interface MyQueue<T> {
    void push(T value);

    void pop();

    T peek();

    void traverse();

    int getSize();

    boolean isEmpty();
    int find(T value);


}
