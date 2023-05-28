public class BinaryTreePrinter<T> {
    private final Node<T> root;

    public BinaryTreePrinter(Node<T> root) {
        this.root = root;
    }

    public void printBinaryTree() {
        int treeHeight = calculateHeight(root);
        printBinaryTreeHelper(root, treeHeight);
    }

    private int calculateHeight(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = calculateHeight(node.getLeftChild());
            int rightHeight = calculateHeight(node.getRightChild());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    private void printBinaryTreeHelper(Node<T> node, int currentLevel) {
        if (node == null) {
            printSpaces(currentLevel);
            System.out.println();
        } else {
            printBinaryTreeHelper(node.getLeftChild(), currentLevel + 1);
            printSpaces(currentLevel);
            System.out.print(node.getData());
            System.out.println();
            printBinaryTreeHelper(node.getRightChild(), currentLevel + 1);
        }
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("   ");
        }
    }
}
