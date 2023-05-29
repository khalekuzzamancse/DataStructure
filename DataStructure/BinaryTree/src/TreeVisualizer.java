import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeVisualizer<T> {
    private final int[][] matrix;
    private final BinaryTree<T> tree;
    private final List<T> nodes;

    public TreeVisualizer(int levels, BinaryTree<T> tree) {
        this.tree = tree;
        matrix = new TreePrintingMatrixGenerator(levels).getMatrix();
        nodes = new ArrayList<>();
    }

    public void visualize() {
        visualizeTree();
        placeIntoMatrix();
        printOnlyNodePosition();
    }

    private void visualizeTree() {

        Queue<Node<T>> queue = new LinkedList<>();
        /*
        if tree is empty do nothing
         */
        if (tree.isEmpty()) {
            return;
        }
        queue.add(tree.root);
        while (!queue.isEmpty()) {
            Node<T> current = queue.remove();
            nodes.add(current.getData());
            addChildToQueue(queue, current);
        }
    }

    private void placeIntoMatrix() {
//        System.out.println(nodes);
        int cnt = 0;
        int cols = matrix[0].length;
        for (int[] ints : matrix) {
            for (int col = 0; col < cols; col++) {
                if (ints[col] == 1) {

                    if (cnt < nodes.size()) {
                        ints[col] = (int) nodes.get(cnt);
                        cnt++;
                    }
                    else{
                        ints[col] = 0;
                    }

                    // System.out.print(ints[col] + " ");
                } else {
                    // System.out.print(" " + " ");
                }

            }
            System.out.println();
        }

        // System.out.println(nodes);
    }

    private void printOnlyNodePosition() {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int[] ints : matrix) {
            for (int col = 0; col < cols; col++) {
                if (ints[col] != 0) {
                    System.out.print(ints[col] + " ");
                } else {
                    System.out.print(" " + " ");
                }

            }
            System.out.println();
        }
    }

    private void addChildToQueue(Queue<Node<T>> queue, Node<T> parent) {
        if (parent.hasLeftChild()) {
            queue.add(parent.getLeftChild());
        }
        if (parent.hasRightChild()) {
            queue.add(parent.getRightChild());
        }
    }


}
