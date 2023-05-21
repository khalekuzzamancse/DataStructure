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
        //Steps:
        //1.If the list is empty then it is going to the first node of list
        //2.Otherwise, the Node become the last(tail) node
        //3.So the new node need to linked with the old tail node
        //4.the tail node need to update with the new tail node
        //5.increase the size of the list by 1

        if (isEmpty()) {
            addToFirst(value);
            return;
        }
        Node node = createNodeWithNext(value, null);
        updateNextOf(tail, node);
        updateTail(node);
        increaseSize();
    }

    @Override
    public void insert(T value, int position) {
        //Steps:
        //1.if the position==1 that means the new node will become head node
        //2.if the position==size that means the new node become the tail node
        //3.otherwise we have to go the node that has the position-1==given position
        //then we have to update the nextNode of the position-1 with the new node
        //and, we have to update the nextNode of the newNode with  the node at position
        //increase the size by 1
        boolean shouldAddToFirst = position == 0;
        if (shouldAddToFirst) {
            addToFirst(value);
            return;
        }
        boolean shouldAddToLast = position == size;
        if (shouldAddToLast) {
            addToLast(value);
            return;
        }
        Node nodeAtPosition = getTheNodeAt(position);
        Node newNode = createNodeWithNext(value, nodeAtPosition.next);
        updateNextOf(nodeAtPosition, newNode);
        increaseSize();

    }

    @Override
    public void deleteFirst() {
        //Steps:
        //1.2nd node become the head
        //2.if the list become empty the tail become null
        //3.decrease the size
        updateHead(head.next);
        if (isEmpty()) {
            updateTail(null);
        }
        decreaseSize();

    }

    @Override
    public void deleteLast() {
        //Steps:
        //1.if there is only one node then it is first ,and it is the last node
        //1.the node before the tail,will become the new tail
        boolean isOnlyOneNode = size <= 1;
        if ((isOnlyOneNode)) {
            deleteFirst();
            return;
        }
        Node nodeBeforeTail = getTheNodeAt(size - 1);
        updateNextOf(nodeBeforeTail, null);
        updateTail(nodeBeforeTail);
        decreaseSize();
    }

    @Override
    public void delete(int position) {
        boolean isOutOfBound = (position < 0 || position >= size);
        if (isOutOfBound) {
            return;
        }
        boolean isThisFirstNode = position == 0;
        if (isThisFirstNode) {
            deleteFirst();
            return;
        }
        boolean isThisLastNode = position == size - 1;
        if (isThisLastNode) {
            deleteLast();
            return;
        }
        Node nodeBeforePosition = getTheNodeAt(position - 1);
        Node newNextOfNodeBeforePosition = nodeBeforePosition.next.next;
        updateNextOf(nodeBeforePosition, newNextOfNodeBeforePosition);
        decreaseSize();
    }

    @Override
    public int find(T value) {
        Node current = head;
        for (int currentIndex = 0; currentIndex < size; currentIndex++) {
            boolean isValueMatched = current.value == value;
            if (isValueMatched) {
                return currentIndex;
            }
            current = current.next;
        }
        //if not found,return 1
        return -1;
    }


    @Override
    public boolean isEmpty() {
        return (tail == null || head == null);
    }

    private void updateTail(Node node) {
        tail = node;
    }

    private Node getTheNodeAt(int position) {
        Node current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        return current;
    }

    private void updateNextOf(Node node, Node nextNode) {
        node.next = nextNode;
    }

    private Node createNodeWithNext(T value, Node nextNode) {
        Node node = new Node(value);
        node.next = nextNode;
        return node;
    }

    private void decreaseSize() {
        size--;
    }


}
