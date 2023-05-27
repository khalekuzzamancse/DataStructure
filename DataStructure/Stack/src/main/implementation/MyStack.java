package main.implementation;

public interface MyStack<T> {
    void push(T value);

    void pop();

    T peek();

    void traverse();

    int getSize();

    boolean isEmpty();
    int find(T value);


}
