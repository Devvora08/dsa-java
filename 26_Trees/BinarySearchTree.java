//formulate a binary search tree using recursion.

public class BinarySearchTree {
    public static void main(String[] args) {
        int[] array = {5,2,7,1,4,6,9,8,3,10};
        BST tree = new BST();

        tree.populate(array);
        tree.display();
    }
}

class BST {
    public class Node {
        private int value;
        private int height;
        private Node left;
        private Node right;

        public Node(int val) {
            this.value = val;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public BST() {
    }

    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insertNode(int val) {
        root = insert(val, root);
    }

    private Node insert(int val, Node node) {
        if (node == null) {
            node = new Node(val);
            return node;
        }

        if (val < node.value) {
            node.left = insert(val, node.left);
        }

        if (val > node.value) {
            node.right = insert(val, node.right);
        }

        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        return node;
    }

    public void display() {
        displayBST(root, "Root Node: ");
    }

    public boolean isBalanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }

        return Math.abs(getHeight(node.left) - getHeight(node.right)) <= 1 && balanced(node.left)
                && balanced(node.right);
    }

    private void displayBST(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.getValue());

        displayBST(node.left, "Left child of " + node.getValue() + " : ");
        displayBST(node.right, "Right child of " + node.getValue() + " : ");
    }

    // make an insert populte function
    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insertNode(nums[i]);
        }
    }
}
