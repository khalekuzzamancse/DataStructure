package main.implementation;


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
            makeItOnlyNode(node);
        } else {
            updateNextOf(node, head);
            updatePrevOf(head, node);
            updateHeadBy(node);
        }
        increaseSize();
    }

    @Override
    public void traverse() {
        System.out.println("Size: " + size);
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
        //1.new node "next" points to null because it will become tail
        //2.new node "prev" will be the old tail
        //3.the old tail next will be the new node
        //4.tail will be replaced by the new node
        //5.size will be increase
        updatePrevOf(node, tail);
        updateNextOf(node, null);
        updateNextOf(tail, node);
        updateTailBy(node);
        increaseSize();
    }

    @Override
    public void insert(T value, int position) {
        //Steps:
        //If the position is out box bound then just return
        if (isOutOfBound(position)) {
            return;
        }
        if (isFirstPosition(position)) {
            addToFirst(value);
            return;
        }
        if (isLastPosition(position)) {
            addToLast(value);
            return;
        }
        //Steps:
        //Get the node at the position-1 (let X)and position(Y)
        //replace the "next" of  X by new node
        //replace the prev of Y using new node
        //increase the list size
        Node node = new Node(value);
        Node x = goFromHeadAt(position - 1);
        Node y = x.next;
        makeItMiddleNode(x, node, y);
        increaseSize();
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
        updateHeadBy(node);
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
        updateTailBy(node);
        decreaseSize();
        // 4: after deleting if there is only node
        // 4 : then the only node become the head also
        if (hasOnlyOneNode()) {
            updateHeadBy(node);
        }
    }

    @Override
    public void delete(int position) {
        if (isOutOfBound(position)) {
            return;
        }
        if (isFirstPosition(position)) {
            deleteFirst();
            return;
        }
        if (isLastPosition(position)) {
            deleteLast();
            return;
        }
        //Get the node at the position(target)
        //then get the node before the target(before)
        //get after the node after the target(after)
        //then remove the target(middle)
        //decrease the size
        Node target = goFromHeadAt(position);
        Node before = target.prev;
        Node after = target.next;
        removeAsMiddle(before, target, after);
        decreaseSize();
    }

    private void removeAsMiddle(Node before, Node target, Node after) {
        before.next = after;
        after.prev = before;
    }

    @Override
    public int find(T value) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return (head == null || tail == null);
    }

    private Node getNodeAtPositionForDelete(int position) {
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
        Node current = head;//node at position 0
        for (int index = 1; index <= position; index++) {
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
        updateHeadBy(node);
        updateTailBy(node);
    }

    private void decreaseSize() {
        size--;
    }

    private void updateHeadBy(Node newHead) {
        newHead.prev = null;
        this.head = newHead;
    }

    private void updateTailBy(Node newTail) {
        newTail.next = null;
        this.tail = newTail;
    }

    private void updateNextOf(Node node, Node next) {
        node.next = next;
    }

    private void updatePrevOf(Node node, Node prev) {
        node.prev = prev;
    }

    private void updateNextAndPrevOf(Node node, Node next, Node prev) {
        updateNextOf(node, next);
        updatePrevOf(node, prev);
    }

    private void makeListEmpty() {
        head = null;
        tail = null;
        size = 0;
    }

    private boolean isOutOfBound(int position) {
        return (position < 0 || position >= size);
    }

    private boolean isFirstPosition(int position) {
        return position == 0;
    }

    private boolean isLastPosition(int position) {
        return position == size - 1;
    }

    private void makeItMiddleNode(Node before, Node middle, Node after) {
        //left side connecting
        before.next = middle;
        middle.prev = before;
        //right side connection
        after.prev = middle;
        middle.next = after;
    }
}
