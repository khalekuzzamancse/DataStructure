package linkedlist.implementation;

public class SinglyLinkedList<T> implements MyLinkedList<T> {
    private Node head = null;
    private Node tail = null;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }


    private class Node {
        private final T value;
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
        Node newHead = createNodeWithNext(value, head);
        //making the  old head become the 2nd node of the list
        //making updating the head
        updateHead(newHead);
        increaseSize();
        //updating the tail
        boolean isListHasOnlyOneNode = tail == null;
        if (isListHasOnlyOneNode) {
            updateTail(head);
        }
    }

    private void updateHead(Node node) {
        head = node;
    }

    private void increaseSize() {
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

    @Override
    public void addToLast(T value) {
        if (isEmpty()) {
            addToFirst(value);
            return;
        }
        //the new node become the last node
        //so the new node is linked with the tail
        Node node = createNodeWithNext(value, null);
        updateNextOf(tail, node);
        updateTail(node);
        increaseSize();
        //updating the tail because the new node become the tail


    }


    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    private void updateTail(Node node) {
        tail = node;
    }

    private void updateNextOf(Node node, Node nextNode) {
        node.next = nextNode;
    }

    private Node createNodeWithNext(T value, Node nextNode) {
        Node node = new Node(value);
        node.next = nextNode;
        return node;
    }


}
