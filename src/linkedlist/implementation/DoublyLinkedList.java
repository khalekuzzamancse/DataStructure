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

    public void traverseReverse() {
        Node current = tail;
        for (int index = size - 1; index >= 0; index--) {
            System.out.println(current.value);
            current = current.prev;
        }
    }

    @Override
    public void addToLast(T value) {
        if (isEmpty()) {
            addToFirst(value);
            return;
        }
        Node node = new Node(value);
        //Steps:
        //1.new node next will be null because it will become tail
        //2.new node prev will be the old tail
        //3.the old tail next will be the new node
        //4.tail will be replaced by the new node
        //5.size will be increase
        updatePrevOf(node, tail);
        updateNextOf(node, null);
        updateNextOf(tail, node);
        updateTail(node);
        increaseSize();
    }

    @Override
    public void insert(T value, int position) {

    }

    @Override
    public void deleteFirst() {
        //Steps:
        //if the list is empty then do nothing
        if (isEmpty()) {
            return;
        }
        //if there is only one node then
        if (hasOnlyOneNode()) {
            makeListEmpty();
            return;
        }

        // 1: Pick out the 2nd node
        // 2: make the 2nd node as the head
        // 3: decrease the size
        Node node = head.next;
        updateHead(node);
        decreaseSize();
        //But what is after deletion there left only 1 node in the list
        //then the only node become the tail
        if (hasOnlyOneNode()) {
            makeItOnlyNode(node);
        }

    }

    @Override
    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        if (hasOnlyOneNode()) {
            makeListEmpty();
            return;
        }
        // 1 : Pick the node before the tail
        // 2: Make the picked node as tail
        // 3:Decrease the size
        Node node = tail.prev;
        updateTail(node);
        decreaseSize();
        //after deleting if there is only node node
        //then the only node become the head also
        if (hasOnlyOneNode()) {
            updateHead(node);
        }
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

    private boolean hasOnlyOneNode() {
        return (size == 1);
    }

    private void makeItOnlyNode(Node node) {
        updatePrevOf(node, null);
        updateNextOf(node, null);
        updateHead(node);
        updateTail(node);
    }

    private void decreaseSize() {
        size--;
    }

    private void updateHead(Node newHead) {
        newHead.prev = null;
        this.head = newHead;
    }

    private void updateTail(Node newTail) {
        newTail.next = null;
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

    private void makeListEmpty() {
        head = null;
        tail = null;
        size = 0;
    }
}
