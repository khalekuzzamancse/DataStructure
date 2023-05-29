package implement;

import utils.TreeVisualizer;

import java.util.LinkedList;
import java.util.Queue;

public abstract class MyBinaryTreeA<T> {
    public Node<T> root;
    protected int totalNode = 0;
    public int getTotalLevel(){
        return (int) Math.ceil(Math.log(totalNode) / Math.log(2));
    }

    public MyBinaryTreeA() {
        this.root = null;
    }

    protected Node<T> getEndNode() {
        Queue<Node<T>> queue = new LinkedList<>();
        Node<T> lastLeaf = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> current = queue.remove();
            if (!current.hasLeftChild() || !current.hasRightChild()) {
                lastLeaf = current;
//                System.out.println("Leaf:"+lastLeaf.getData());
                return lastLeaf;
            }
            addChildToQueue(queue, current);

        }
        System.out.println("Leaf:" + lastLeaf.getData());
        return lastLeaf;
    }

    protected void addChildToQueue(Queue<Node<T>> queue, Node<T> parent) {
        if (parent.hasLeftChild()) {
            queue.add(parent.getLeftChild());
        }
        if (parent.hasRightChild()) {
            queue.add(parent.getRightChild());
        }
    }

    public abstract void insert(T data);

    public abstract void traverse();


    protected void updateRoot(Node<T> newRoot) {
        this.root = newRoot;
    }


    public boolean isEmpty() {
        return (root == null);
    }


    protected void removeLeftChildOf(Node<T> parent) {

    }

    protected void removeRightChildOf(Node<T> parent) {

    }

    protected void removeBothChildOf(Node<T> parent) {

    }


    protected Node<T> creteNodeNoChild(T data) {
        return Node.createNodeWithNoChild(data);
    }

    protected Node<T> getRoot() {
        return root;
    }

    public T getRootData() {
        return root.getData();
    }
    protected void visualizeTree(TreeVisualizer visualizer) {

    }


}

