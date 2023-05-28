public abstract class BinaryTree<T> {
    protected Node root;

    private class Node {
        private Node leftChild;
        private Node rightChild;
        private T data;

        public Node(T data) {
            this.leftChild = null;
            this.rightChild = null;
            this.data = data;
        }

    }

    public BinaryTree() {
        this.root = null;
    }

    protected boolean isItLeafNode(Node node) {
        return (node.leftChild == null && node.rightChild == null);
    }

    protected boolean isEmpty() {
        return (root == null);
    }

    protected void updateLeftChildOf(Node parent, Node leftChild) {
        if (parent != null) {
            parent.leftChild = leftChild;
        }
    }

    protected void updateRightChildOf(Node parent, Node rightChild) {
        if (parent != null) {
            parent.rightChild = rightChild;
        }
    }

    protected void updateBothChildOf(Node parent, Node leftChild, Node rightChild) {
        if (parent != null) {
            parent.leftChild = leftChild;
            parent.rightChild = rightChild;
        }
    }

    protected void removeLeftChildOf(Node parent) {
        if (parent != null) {
            parent.leftChild = null;
        }
    }

    protected void removeRightChildOf(Node parent) {
        if (parent != null) {
            parent.rightChild = null;
        }
    }

    protected void removeBothChildOf(Node parent) {
        if (parent != null) {
            parent.leftChild = null;
            parent.rightChild = null;
        }
    }

    protected Node creteNodeWithLeftChild(T data, Node leftChild) {
        Node node = new Node(data);
        node.leftChild = leftChild;
        node.rightChild = null;
        return node;
    }

    protected Node creteNodeWithRightChild(T data, Node rightChild) {
        Node node = new Node(data);
        node.leftChild = null;
        node.rightChild = rightChild;
        return node;
    }

    protected Node creteNodeWithBothChild(T data, Node leftChild, Node rightChild) {
        Node node = new Node(data);
        node.leftChild = leftChild;
        node.rightChild = rightChild;
        return node;
    }
}
