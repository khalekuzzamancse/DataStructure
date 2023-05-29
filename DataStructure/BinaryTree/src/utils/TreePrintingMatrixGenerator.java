package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreePrintingMatrixGenerator {
    private final String[][] matrix;
    private final String NODE_CELL_VALUE = "1";
    private final String BLANK_CELL_VALUE = "0";

    TreePrintingMatrixGenerator(int treeTotalLevels) {
        int lastLevelTotalChild = (int) Math.pow(2, treeTotalLevels - 1);
        int totalCellInLastLevel = (2 * lastLevelTotalChild) - 1;

        //  int[][] matrix = new int[treeTotalLevels][totalCellInLastLevel];
        this.matrix = new String[treeTotalLevels][totalCellInLastLevel];


        // Initialize the matrix with 0
        for (int row = 0; row < treeTotalLevels; row++) {
            for (int col = 0; col < totalCellInLastLevel; col++) {
                matrix[row][col] = BLANK_CELL_VALUE;
            }
        }

//        printMatrix();
//        System.out.println("\n");
        updateMatrix();
        //  printMatrix();

    }


    public void printMatrix() {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (String[] ints : matrix) {
            for (int col = 0; col < cols; col++) {

                System.out.print(ints[col] + " ");
            }
            System.out.println();
        }
    }

    public void printOnlyNodePosition() {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (String[] ints : matrix) {
            for (int col = 0; col < cols; col++) {
                if (Objects.equals(ints[col], NODE_CELL_VALUE)) {
                    System.out.print(ints[col] + " ");
                } else {
                    System.out.print(" " + " ");
                }

            }
            System.out.println();
        }
    }

    public String[][] getMatrix() {
        return matrix;
    }

    private void updateMatrix() {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Update the last row of the matrix
        List<Integer> pairs = updateLastLevels();

        // System.out.println(pairs);
        for (int row = rows - 2; row >= 0; row--) {
            pairs = getPreviousRowColumns(pairs);
            updateCells(row, pairs);
            //  System.out.println(i + ":" + pairs);
        }

    }

    private List<Integer> updateLastLevels() {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> pairs = new ArrayList<>();
        for (int col = 0; col < cols; col += 2) {
            matrix[rows - 1][col] = NODE_CELL_VALUE;
            pairs.add(col);
        }
        return pairs;
    }

    private List<Integer> getPreviousRowColumns(List<Integer> pairs) {
        List<Integer> newPairs = new ArrayList<>();
        for (int i = 0; i < pairs.size(); i = i + 2) {
            int column = (pairs.get(i) + pairs.get(i + 1)) / 2;
            newPairs.add(column);
        }
        return newPairs;
    }

    private void updateCells(int row, List<Integer> columns) {
        for (int column : columns) {
            matrix[row][column] = NODE_CELL_VALUE;
        }
    }

    public String getBLANK_CELL_VALUE() {
        return BLANK_CELL_VALUE;
    }

    public String getNODE_CELL_VALUE() {
        return NODE_CELL_VALUE;
    }
}
