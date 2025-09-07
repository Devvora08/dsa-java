public class SegmentTree {
    public static void main(String[] args) {
        int[] arr = {3,8,6,7,-2,-8, 4,9};

        Segment tree = new Segment(arr);
        tree.display();

        System.out.println(tree.query(1, 6));
    }
}

class Segment {
    private class Node {
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        public Node(int start, int end) {
            this.startInterval = start;
            this.endInterval = end;
        }
    }

    Node root;

    public Segment(int[] arr) {
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    private Node constructTree(int[] arr, int start, int end) {
        if (start == end) {
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        Node node = new Node(start, end);
        int mid = start + (end - start) / 2;
        node.left = this.constructTree(arr, start, mid);
        node.right = this.constructTree(arr, mid + 1, end);
        node.data = node.left.data + node.right.data;
        return node;
    }

    public void display() {
        display(this.root);
    }

    private void display(Node node) {
        if (node == null) return;
        String str = "";
        str += "Interval [" + node.startInterval + "-" + node.endInterval + "] -> " + node.data;
        if (node.left != null) {
            str += " | Left: [" + node.left.startInterval + "-" + node.left.endInterval + "] -> " + node.left.data;
        }
        if (node.right != null) {
            str += " | Right: [" + node.right.startInterval + "-" + node.right.endInterval + "] -> " + node.right.data;
        }
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public int query(int qStart, int qEnd) {
        return this.query(this.root, qStart, qEnd);
    }

    private int query(Node node, int qsi, int qei) {
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data;
        } else if (node.startInterval > qei || node.endInterval < qsi) {
            return 0;
        } else {
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }
}

