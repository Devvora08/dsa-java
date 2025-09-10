import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

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

    // Q - Serialize / deserialize tree in string form. - turn binary tree to string, turn string back to tree
    public List<String> serialize(Node node) {
        List<String> list = new ArrayList<>();
        serializeHelper(node, list);
        return list;
    }
    private void serializeHelper(Node node, List<String> list){
        if(node == null) {
            list.add("null");
            return;
        } 
        list.add(String.valueOf(node.value));

        serializeHelper(node.left, list);
        serializeHelper(node.right, list);
    }

    public Node deserialize(List<String> list) {
        Collections.reverse(list);
        Node node = deserializeHelper(list);
        return node;
    }

    private Node deserializeHelper(List<String> list) {
        String val = list.remove(list.size() - 1);

        if(val.charAt(0) == 'n') {
            return null;
        }

        Node node = new Node(Integer.parseInt(val));
        node.left = deserializeHelper(list);
        node.right = deserializeHelper(list);

        return node;
    }

    // Q - from root to a leaf - find if path sum == target - return true/false if path exists
    public boolean pathSum(Node root, int target) {
        if(root == null) {
            return false;
        }

        if(root.value == target && root.left == null && root.right == null) {
            return true;
        }

        return pathSum(root.left, target - root.value) || pathSum(root.right, target - root.value);
    }

    // Q - path sum numbers - return sum of all paths from root to leaf - with joining numbers on each path as 1 singular 
    // eg - root to leaf = 1,3,4 = 134 for that path is singular to be added to all path singular sums
    public int pathNumSum(Node root){
        return helperPath(root, 0);
    }
    private int helperPath(Node root, int sum) {
        if(root == null) return 0;

        sum = sum * 10 + root.value;
        if(root.left == null && root.right == null) return sum; // no need to multiply by 10 further

        return helperPath(root.left, sum) + helperPath(root.right, sum);
    }

    // Q - return sum of maximum value of path, allowed from anywhere to anywhere
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(Node root) {
        maxHelper(root);
        return ans;
    }
    private int maxHelper(Node root) {
        if(root == null) {
            return 0;
        }

        int left = maxHelper(root.left);
        int right = maxHelper(root.right);

        // if negative value found in left/right, just take 0 and dont consider
        left = Math.max(0, left);
        right = Math.max(0, right);

        int pathSum = left + right + root.value;
        ans = Math.max(pathSum, ans);
        return Math.max(left, right) + root.value;
    }

    // Q - count number of paths == target sum, could be from anywhere to anywhere
    public int countAllPaths(Node node, int sum) {
        List<Integer> path = new LinkedList<>();
        return helperCountPaths(node, sum, path);
    }
    private int helperCountPaths(Node node, int sum, List<Integer> path) {
        if(node == null) {
            return 0;
        }

        path.add(node.value);
        int count = 0;
        int s = 0;

        ListIterator<Integer> itr = path.listIterator(path.size());
        while(itr.hasPrevious()) {
            s += itr.previous();
            if(s == sum) {
                count++;
            }
        }

        count += helperCountPaths(node.left, sum, path) + helperCountPaths(node.right, sum, path);

        // backtrack
        path.remove(path.size() - 1);
        return count;
    }
}
