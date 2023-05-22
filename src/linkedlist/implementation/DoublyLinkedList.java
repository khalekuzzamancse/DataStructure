package linkedlist.implementation;

public class DoublyLinkedList<T> implements MyLinkedList<T> {
    private class Node {
        private final T value;
        private Node next;
        private Node prev;

        Node(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    //
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void addToFirst(T value) {
        Node node = new Node(value);
        if (isEmpty()) {
            updateHead(node);
            updateTail(node);
        } else {
            updateNextOf(node, head);
            updatePrevOf(head, node);
            updateHead(node);
        }
        increaseSize();
    }

    @Override
    public void traverse() {
        Node current = head;
        for (int index = 0; index < size; index++) {
            System.out.println(current.value);
            current = current.next;
        }
    }
    public void traverseReverse(){
        Node current = tail;
        for (int index = size-1; index >= 0; index--) {
            System.out.println(current.value);
            current = current.prev;
        }
    }

    @Override
    public void addToLast(T value) {

    }

    @Override
    public void insert(T value, int position) {

    }

    @Override
    public void deleteFirst() {

    }

    @Override
    public void deleteLast() {

    }

    @Override
    public void delete(int position) {

    }

    @Override
    public int find(T value) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return (head == null || tail == null);
    }

    private Node getNodeAtPosition(int position) {
        Node node;
        boolean isNearFromHead = (position <= size / 2);
        if (isNearFromHead) {
            node = goFromHeadAt(position);
        } else {
            node = goFromTailAt(position);
        }
        return node;
    }

    private Node goFromHeadAt(int position) {
        Node current = head;
        for (int index = 0; index <= position; index++) {
            current = current.next;
        }
        return current;
    }

    private Node goFromTailAt(int position) {
        Node current = tail;
        for (int index = size - 1; index >= position; index--) {
            current = current.prev;
        }
        return current;
    }

    private void increaseSize() {
        size++;
    }

    private void decreaseSize() {
        size--;
    }

    private void updateHead(Node newHead) {
        this.head = newHead;
    }

    private void updateTail(Node newTail) {
        this.tail = newTail;
    }

    private void updateNextOf(Node node, Node next) {
        node.next = next;
    }

    private void updatePrevOf(Node node, Node prev) {
        node.prev = prev;
    }

    private void updateNextAndPrev(Node node, Node next, Node prev) {
        updateNextOf(node, next);
        updatePrevOf(node, prev);
    }

    private Node createAsHead(T value) {
        Node node = new Node(value);
        updatePrevOf(node, null);
        return node;
    }

    private Node createAsTail(T value) {
        Node node = new Node(value);
        updateNextOf(node, null);
        return node;
    }
}
