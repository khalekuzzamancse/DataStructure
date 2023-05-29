package implement;

public class Node<T> {
    private Node<T> leftChild;
    private Node<T> rightChild;
    private T data;

    private Node() {
    }

    public static <T> Node<T> createNodeWithNoChild(T data) {
        Node<T> node = new Node<T>();
        node.data=data;
        node.leftChild = null;
        node.rightChild = null;
        return node;
    }

    public void updateLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void updateRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<T> removeLeftChild() {
        Node<T> child = this.leftChild;
        this.leftChild = null;
        return child;
    }

    public Node<T> removeRightChild() {
        Node<T> child = this.rightChild;
        this.rightChild = null;
        return child;
    }


    public Node<T> getLeftChild() {
        return leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public T getData() {
        return data;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public boolean isLeafNode() {
        return (!hasLeftChild() && !hasRightChild());
    }
}
