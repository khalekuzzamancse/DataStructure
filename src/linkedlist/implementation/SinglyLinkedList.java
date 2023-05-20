package linkedlist.implementation;

public class SinglyLinkedList<T> implements MyLinkedList<T> {
    private Node head;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }


    private class Node {
        private T value;
        private Node next = null;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void addToFirst(T value) {
        //create a new node that will act as the head
        Node newHead = new Node(value);
        //making the  old head become the 2nd node of the list
        newHead.next = head;
        //making updating the head
        head = newHead;
        //increase the list size by 1
        size++;
    }

    public void traverse() {
        Node currentNode = head;
        boolean isEndOfTheList = currentNode == null;
        while (!isEndOfTheList) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
            isEndOfTheList = currentNode == null;
        }
    }


}
