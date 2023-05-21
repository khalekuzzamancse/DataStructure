package linkedlist;

import linkedlist.implementation.MyLinkedList;
import linkedlist.implementation.SinglyLinkedList;

public class Output {
    public static void main(String[] args) {
        MyLinkedList<String> list = new SinglyLinkedList<>();
        list.addToFirst("Babul2");
        list.addToFirst("Babul1");
        list.addToLast("Babul3");
        list.insert("babul0",0);
        list.insert("babbul4",4);
        list.insert("ba",2);
        list.deleteLast();
        list.traverse();
    }
}
