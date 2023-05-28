public class Node2<T> {
    private Node2 leftChild;
    private Node2 rightChild;
    private T data;

    private Node2(T data) {
        this.leftChild = null;
        this.rightChild = null;
        this.data = data;
    }

    public Node2<T> createNodeWithNoChild(T data) {
        Node2<T> node2 = new Node2<T>(data);
        node2.leftChild = null;
        node2.rightChild = null;
        return node2;
    }

    public Node2<T> creteNodeWithLeftChild(T data, Node2<T> leftChild) {
        Node2<T> node2 = new Node2<T>(data);
        node2.leftChild = leftChild;
        node2.rightChild = null;
        return node2;
    }

    public Node2<T> creteNodeWithRightChild(T data, Node2<T> rightChild) {
        Node2<T> node2 = new Node2<T>(data);
        node2.leftChild = null;
        node2.rightChild = rightChild;
        return node2;
    }

    public boolean hasItRightChild() {
        return (this.rightChild != null);
    }

    public boolean hasItLeftChild() {
        return (this.leftChild != null);
    }

    public boolean isLeafNode() {
        return (this.leftChild == null && this.rightChild == null);
    }

    public void updateLeftChildOf(Node2<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void updateRightChildOf(Node2<T> rightChild) {
        this.rightChild = rightChild;

    }

    public void updateBothChildOf(Node2<T> leftChild, Node2<T> rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public Node2<T> getLeftChild() {
        return this.leftChild;
    }

    public Node2 getRightChild() {
        return rightChild;
    }
}
