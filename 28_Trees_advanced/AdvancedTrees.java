// breadth first search - print level by level

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class AdvancedTrees {
    public static void main(String[] args) {
        // main bfs class consists all questions with methods as answers
    }
}

class Bfs {
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private Node next; // only for connect question

        public Node(int val) {
            this.value = val;
        }

        public int getValue() {
            return value;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }

    // Q - return the level successor of key
    public Node findSuccessor(Node root, int key) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            Node currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.value == key)
                break;
        }

        return queue.peek();
    }

    // Q - zig zag level order traversal - bfs (left to right) - (right to left) ...
    // etc from root
    public List<List<Integer>> zigZagOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);

        boolean reverse = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {

                if (!reverse) {
                    Node currentNode = queue.pollFirst();
                    currentLevel.add(currentNode.value);
                    if (currentNode.left != null) {
                        queue.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.addLast(currentNode.right);
                    }
                } else {
                    Node currentNode = queue.pollLast();
                    if (currentNode.right != null) {
                        queue.addFirst(currentNode.right);
                    }
                    currentLevel.add(currentNode.value);
                    if (currentNode.left != null) {
                        queue.addFirst(currentNode.left);
                    } 
                }
                   
            }
            reverse = !reverse;  
            result.add(currentLevel);
        }

        return result;
    }

    // Q - given a perfect binary tree, connect all nodes of one level with .next given in node.
    public Node connectLevels(Node root) {
        if(root == null) {
            return null;
        }

        Node leftMost = root;
        while(leftMost.left != null) {
            Node current = leftMost;

            while(current != null) {
                current.left.next = current.right;
                if(current.next != null) {
                    current.right.next = current.next.left;
                }

                current = current.next;
            }
            leftMost = leftMost.left;
        }

        return root;
    }

    // Q - return boolean if nodes in same level, but not siblings, should be cousins
    public boolean isCousins(Node root, int x, int y) {
        Node xx = findNode(root, x);
        Node yy = findNode(root, y);

        return (
            (level(root, xx, 0) == level(root, yy,0)) && (!isSibling(root, xx,yy))
        );
    }

    private Node findNode(Node node, int x) {
        if(node == null) {
            return null;
        }
        if(node.value == x) return node;
        Node n = findNode(node.left, x);
        if(n != null) return n;

        return findNode(node.right, x);
    }

    private boolean isSibling(Node node, Node x, Node y) {
        if(node == null) return false;

        return (
            (node.left == x && node.right == y) || (node.left == y && node.left == x) || isSibling(node.left, x, y) || isSibling(node.right, x, y)
        );
    }

    private int level(Node node, Node x, int lev) {
        if(node == null) return 0;
        if(node == x) {
            return lev;
        }

        int l = level(node.left, x, lev+1);
        if(l!= 0) return l;

        return level(node.right, x, lev+1);
    }

    public boolean isSymmetric(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        
        while(!queue.isEmpty()) {
            Node left = queue.poll();
            Node right = queue.poll();

            if(left == null && right == null) continue;
            if(left == null || right == null) return false;

            if(left.value != right.value) return false;

            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        return true;
    }
}
