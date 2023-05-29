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
        //


    }

    public void visualize() {
        visualizeTree();
        printStringMatrix(convertMatrixToString());

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


    private String[][] convertMatrixToString() {
        int rows = matrix.length;
        int cols = matrix[0].length;
        String[][] stringMatrix = new String[rows][cols];
        int cnt = 0;

        for (int i = 0; i < rows; i++) {
            String fillBlankCellWith = ".";
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    stringMatrix[i][j] = fillBlankCellWith;
                } else {
                    if (cnt < nodes.size()) {
                        stringMatrix[i][j] = nodes.get(cnt).toString();
                        cnt++;
                    } else {
                        stringMatrix[i][j] = fillBlankCellWith;
                    }

                }
            }
        }
        return stringMatrix;
    }

    private static void printStringMatrix(String[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
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
