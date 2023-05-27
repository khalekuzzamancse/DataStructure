package main.implementation;

public class Output {
    public static void main(String[] args) {
        MyStack<Integer> stack = new CustomStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.traverse();

    }
}
