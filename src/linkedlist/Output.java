package linkedlist;

import linkedlist.implementation.MyLinkedList;
import linkedlist.implementation.SinglyLinkedList;

public class Output {
    public static void main(String[] args) {
        MyLinkedList<String> list = new SinglyLinkedList<>();
        list.addToFirst("Abul");
        list.addToFirst("Babul");
        list.traverse();
    }
}
