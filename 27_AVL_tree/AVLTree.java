// self balancing binary search tree

public class AVLTree {
    public static void main(String[] args) {
        AVL tree = new AVL();
        for (int i = 0; i < 1000; i++) {
            tree.insertNode(i);
        }

        System.out.println(tree.getHeight());
    }
}

class AVL {
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

    public AVL() {
    }

    public int getHeight() {
        return getHeight(root);
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

        return rotate(node);
    }

    private Node rotate(Node node) {
        if (getHeight(node.left) - getHeight(node.right) > 1) {
            // left heavy, 2 cases in left heavy
            if (getHeight(node.left.left) - getHeight(node.left.right) > 0) {
                // left - left case ----> right rotate on p (node)
                return rightRotate(node);
            }
            if (getHeight(node.left.left) - getHeight(node.left.right) < 0) {
                // left - right case ----> left rotate on child (p - c - gc) ,right rotate on p
                // (node)
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if (getHeight(node.left) - getHeight(node.right) < -1) {
            // right heavy, 2 cases in right heavy
            if (getHeight(node.right.left) - getHeight(node.right.right) < 0) {
                // right - right case ----> left rotate on p (node)
                return leftRotate(node);
            }
            if (getHeight(node.right.left) - getHeight(node.right.right) > 0) {
                // right - left case ----> right rotate on child (p - c - gc) ,left rotate on p
                // (node)
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    public Node rightRotate(Node p) {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(getHeight(p.left), getHeight(p.right) + 1);
        c.height = Math.max(getHeight(c.left), getHeight(c.right) + 1);

        return c;
    }

    public Node leftRotate(Node c) {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(getHeight(p.left), getHeight(p.right) + 1);
        c.height = Math.max(getHeight(c.left), getHeight(c.right) + 1);

        return p;
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

    // Pre-order N - L - R
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // in order - L - N - R
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        preOrder(node.left);
        System.out.print(node.value + " ");
        preOrder(node.right);
    }

    // post Order L - R - N
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.value + " ");
    }

}
