package main.implementation;

public interface MyLinkedList<T> {
    void addToFirst(T value);

    void traverse();

    void addToLast(T value);

    void insert(T value, int position);
    void deleteFirst();
    void deleteLast();
    void delete(int position);
    int find(T value);

    boolean isEmpty();
}
