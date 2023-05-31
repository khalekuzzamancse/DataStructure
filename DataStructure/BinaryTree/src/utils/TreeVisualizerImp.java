package utils;

import implement.MyBinaryTree;
import implement.Node;

import java.util.*;

public class TreeVisualizerImp<T> implements TreeVisualizer {
    private final String[][] matrix;
    private final MyBinaryTree<T> tree;
    private final List<T> nodes;
    private final TreePrintingMatrixGenerator generator;
    private final String BLANK_CELL_VALUE;

    public TreeVisualizerImp(MyBinaryTree<T> tree) {
        BLANK_CELL_VALUE = "*";
        this.tree = tree;
        this.generator = new TreePrintingMatrixGenerator(tree.getTotalLevel() + 1);
        matrix = generator.getMatrix();
        nodes = new ArrayList<>();
    }

    public TreeVisualizerImp(MyBinaryTree<T> tree, String BLANK_CELL_VALUE) {
        this.BLANK_CELL_VALUE = BLANK_CELL_VALUE;
        this.tree = tree;
        this.generator = new TreePrintingMatrixGenerator(tree.getTotalLevel() + 1);
        matrix = generator.getMatrix();
        nodes = new ArrayList<>();
    }

    @Override
    public void visualize() {
        getTreeNodes();
        String[][] outputTree = placeNodeIntoMatrix();
        printStringMatrix(outputTree);

    }

    private void getTreeNodes() {

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


    private String[][] placeNodeIntoMatrix() {
        int rows = matrix.length;
        int cols = matrix[0].length;
        String[][] stringMatrix = new String[rows][cols];
        int cnt = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j].equals(generator.getBLANK_CELL_VALUE())) {
                    stringMatrix[i][j] = BLANK_CELL_VALUE;
                } else {
                    if (cnt < nodes.size()) {
                        stringMatrix[i][j] = nodes.get(cnt).toString();
                        cnt++;
                    } else {
                        stringMatrix[i][j] = BLANK_CELL_VALUE;
                    }

                }
            }
        }
        return stringMatrix;
    }

    private static void printStringMatrix(String[][] matrix) {
        int cols = matrix[0].length;
        for (String[] strings : matrix) {
            for (int j = 0; j < cols; j++) {
                System.out.print(strings[j] + " ");
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
