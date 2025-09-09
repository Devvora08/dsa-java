public class DFSTreesQ {
    public static void main(String[] args) {

    }
}

// dfs questions, inorder, preorder, postorder traversal questions to devolop
// intuition
class DFS {
    public class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int val) {
            this.value = val;
        }

        public int getValue() {
            return value;
        }
    }

    // Q - return the diameter of a tree, that may or may not consist root node
    int diameter = 0;
    public int diameterOfTree(Node root) {
        height(root);
        return diameter - 1;
    }
    private int height(Node root) {
        if(root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int dia = leftHeight = rightHeight + 1;
        diameter = Math.max(dia, diameter);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Q - invert a binary tree
    public Node invertTree(Node root) {
        // post order - swap from the lowest level, as you approach top
        if(root == null) {
            return null;
        }

        Node left = invertTree(root.left);
        Node right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    // Q - flatten binary tree to linked list, using pre order traversal
    public void flatten(Node root) {
        Node current = root;
        while(current != null) {
            if(current.left != null) {
                Node temp = current.left;
                while(temp.right != null) {
                    temp = temp.right;
                }

                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    // Q - check valid binary search tree - return true/false
    public boolean isValidBST(Node root) {
        return helper(root, null, null);
    }
    private boolean helper(Node node, Integer low, Integer high) {
        if(node == null) {
            return true;
        }

        if(low != null && node.value <= low) {
            return false;
        }
        if(high != null && node.value >= high) {
            return false;
        }

        boolean leftTree = helper(node.left, low, node.value);
        boolean rightTree = helper(node.right, node.value, high);

        return leftTree && rightTree;
    }

    // Q - lowest common ancestor
    public Node lowestCA(Node root, Node p, Node q) {
        if(root == null) {
            return null;
        }

        if(root == p || root == q) {
            return root;
        }
        Node left = lowestCA(root.left, p, q);
        Node right = lowestCA(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    // Q - return kth smallest value in 1 - indexed BST
    private int count = 0; 
    private int result = -1; 
    public int kSmallest(Node root, int k) {
        count = 0; 
        result = -1;
        inOrder(root, k);
        return result;
    }

    private void inOrder(Node node, int k) {
        if (node == null || result != -1) return;

        inOrder(node.left, k);
        
        count++;
        if (count == k) {
            result = node.value;
            return;
        }

        inOrder(node.right, k);
    }
}
