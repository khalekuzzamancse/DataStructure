package main.implementation;


public class Output {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addToFirst(10);
        list.addToFirst(9);
        list.addToLast(11);
        list.addToLast(12);
        list.insert(13, 3);
        list.delete(3);
        list.traverse();

    }
}
