package implement;

import utils.TreeVisualizerImp;

public class BinaryTreeOutput {
    public static void main(String[] args) {
        MyBinaryTree<String> tree = new MyBinaryTreeImp<>();
        tree.insert("1");
        tree.insert("2");
        tree.insert("3");
        tree.insert("4");
        tree.insert("5");
        tree.insert("6");
        tree.insert("7");
        tree.visualizeTree(
                new TreeVisualizerImp<>(tree, " ")
        );
        tree.remove("2");


        tree.visualizeTree(
                new TreeVisualizerImp<>(tree, " ")
        );

    }
}
