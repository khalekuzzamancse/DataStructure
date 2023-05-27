package main.implement;

import java.util.ArrayList;
import java.util.List;

public class CustomQueue<T> implements MyQueue<T> {
    private final List<T> queue;
    private int size;

    public CustomQueue() {
        queue = new ArrayList<>();
        size = 0;
    }

    @Override
    public void push(T value) {
        queue.add(value);
        increaseSize();
    }

    void increaseSize() {
        size++;
    }

    void decreaseSize() {
        size--;
    }

    @Override
    public void pop() {
        if (!isEmpty()) {
            queue.remove(0);
            decreaseSize();
        }
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return queue.get(0);
        }
        return null;
    }

    @Override
    public void traverse() {
        for (int index = 0; index < size; index++) {
            System.out.println(queue.get(index));
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int find(T value) {
        int foundAt = -1;
        for (int index = 0; index < size; index++) {
            T currentValue = queue.get(index);
            boolean isMatched = (value == currentValue);
            if (isMatched) {
                foundAt=index;
                return foundAt;
            }
        }
        return foundAt;
    }
}
