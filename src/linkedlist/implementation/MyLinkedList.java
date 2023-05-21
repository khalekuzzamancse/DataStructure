package linkedlist.implementation;

public interface MyLinkedList<T> {
    void addToFirst(T value);

    void traverse();

    void addToLast(T value);

    void insert(T value, int position);

    boolean isEmpty();
}
