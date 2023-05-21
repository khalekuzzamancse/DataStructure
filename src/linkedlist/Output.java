package linkedlist;

import linkedlist.implementation.MyLinkedList;
import linkedlist.implementation.SinglyLinkedList;

public class Output {
    public static void main(String[] args) {
        MyLinkedList<String> list = new SinglyLinkedList<>();
        list.addToFirst("Babul2");
        list.addToFirst("Babul1");
        list.addToLast("Babul3");
        list.traverse();
        System.out.println(list.find("Babul4"));
    }
}
