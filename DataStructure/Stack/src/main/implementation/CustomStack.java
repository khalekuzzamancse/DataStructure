package main.implementation;

import java.util.ArrayList;
import java.util.List;

public class CustomStack<T> implements MyStack<T> {
    private final List<T> stack;
    private int size;

    public CustomStack() {
        stack = new ArrayList<>();
        size = 0;
    }

    @Override
    public void push(T value) {
        stack.add(value);
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
            stack.remove(size - 1);
            decreaseSize();
        }
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return stack.get(size - 1);
        }
        return null;
    }

    @Override
    public void traverse() {
        for (int index = 0; index < size; index++) {
            System.out.println(stack.get(index));
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
            T currentValue = stack.get(index);
            boolean isMatched = (value == currentValue);
            if (isMatched) {
                foundAt=index;
                return foundAt;
            }
        }
        return foundAt;
    }
}
