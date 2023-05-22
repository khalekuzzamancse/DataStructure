package linkedlist;

import linkedlist.implementation.DoublyLinkedList;
import linkedlist.implementation.MyLinkedList;
import linkedlist.implementation.SinglyLinkedList;

public class Output {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addToFirst(10);
        list.addToFirst(9);
        list.addToFirst(8);
       list.traverse();
      //  list.traverseReverse();

    }
}
