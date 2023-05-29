import java.util.ArrayList;
import java.util.List;

public class TreePrintingMatrixGenerator {
    private final int[][] matrix;

    TreePrintingMatrixGenerator(int treeTotalLevels) {
        int lastLevelTotalChild = (int) Math.pow(2, treeTotalLevels - 1);
        int totalCellInLastLevel = (2 * lastLevelTotalChild) - 1;

        //  int[][] matrix = new int[treeTotalLevels][totalCellInLastLevel];
        this.matrix = new int[treeTotalLevels][totalCellInLastLevel];


        // Initialize the matrix with 0
        for (int row = 0; row < treeTotalLevels; row++) {
            for (int col = 0; col < totalCellInLastLevel; col++) {
                matrix[row][col] = 0;
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

        for (int[] ints : matrix) {
            for (int col = 0; col < cols; col++) {
                System.out.print(ints[col] + " ");
            }
            System.out.println();
        }
    }
    public void printOnlyNodePosition() {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int[] ints : matrix) {
            for (int col = 0; col < cols; col++) {
                if(ints[col]==1){
                    System.out.print(ints[col] + " ");
                }
                else {
                    System.out.print(" "+" ");
                }

            }
            System.out.println();
        }
    }

    public int[][] getMatrix() {
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
            updateCells( row, pairs);
            //  System.out.println(i + ":" + pairs);
        }

    }

    private List<Integer> updateLastLevels() {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> pairs = new ArrayList<>();
        for (int col = 0; col < cols; col += 2) {
            matrix[rows - 1][col] = 1;
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

    private void updateCells( int row, List<Integer> columns) {
        for (int column : columns) {
            matrix[row][column] = 1;
        }
    }
}
