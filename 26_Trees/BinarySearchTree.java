//formulate a binary search tree using recursion.

public class BinarySearchTree {
    public static void main(String[] args) {
        int[] array = {5,2,7,1,4,6,9,8,3,10};
        BST tree = new BST();

        tree.populate(array);
        // tree.display();
        System.out.println("Pre order traversal - N - L - R");
        tree.preOrder();
        System.out.println();
        System.out.println("In order traversal - L - N - R");
        tree.inOrder();
        System.out.println();
        System.out.println("Post order traversal - L - R - N");
        tree.postOrder();
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


    //Pre-order N - L - R
    public void preOrder() {
        preOrder(root);
    } 
    private void preOrder(Node node) {
        if(node == null) return;

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // in order - L - N - R
    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(Node node) {
        if(node == null) return;
        preOrder(node.left);
        System.out.print(node.value + " ");
        preOrder(node.right);
    }

    // post Order L - R - N
    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(Node node) {
        if(node == null) return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.value + " ");
    }

}
