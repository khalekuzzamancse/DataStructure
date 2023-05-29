package implement;

import utils.TreeVisualizer;
import utils.TreeVisualizerImp;

import java.util.LinkedList;
import java.util.Queue;

public class MyBinaryTree<T> extends MyBinaryTreeA<T> {


    @Override
    public void insert(T data) {
        /*
        Steps:
        1.if the tree is empty the new node become the root with no child
        otherwise
        2.Go to the node which left or right child is empty
        2.1 go to  level by level and find the leftmost node
        2.2 which left or right child is empty
        2.3 we will  filling from left side
        2.4 if the left child is empty then add the new node as left child
        2.5 if the right child is empty then add the node as the right child
         */
        Node<T> node = Node.createNodeWithNoChild(data);
        if (isEmpty()) {
            updateRoot(node);
            increaseTotalNode();
            return;
        }
        Node<T> lastLeaf = getEndNode();
        if (!lastLeaf.hasLeftChild()) {
            lastLeaf.updateLeftChild(node);
            increaseTotalNode();
            //  System.out.println(data + ":" + "Added Left of " + lastLeaf.getData());
            return;
        }
        if (!lastLeaf.hasRightChild()) {
            increaseTotalNode();
            lastLeaf.updateRightChild(node);
            // System.out.println(data + ":" + "Added Right of " + lastLeaf.getData());
            return;
        }

    }

    private void increaseTotalNode() {
        totalNode++;
    }


    @Override
    public void traverse() {
        Queue<Node<T>> queue = new LinkedList<>();
        /*
        if tree is empty do nothing
         */
        if (isEmpty()) {
            return;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> current = queue.remove();
            printNodeData(current);
            addChildToQueue(queue, current);
        }

    }

    @Override
    public void visualizeTree(TreeVisualizer visualizer) {
        visualizer.visualize();
    }

    private void printParentWithChild(Node<T> node) {
        System.out.print(node.getData());
        System.out.print(":( ");

        if (node.hasLeftChild()) {
            System.out.print(node.getLeftChild().getData());
        }
        System.out.print(", ");
        if (node.hasRightChild()) {
            System.out.print(node.getRightChild().getData());
        }
        System.out.println(" )");
    }

    private void printNodeData(Node<T> node) {

        System.out.println(node.getData());

    }
    //okay


}
