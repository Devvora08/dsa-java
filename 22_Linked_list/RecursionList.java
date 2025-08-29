public class RecursionList {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(50);
        list.insertFirst(40);
        list.insertFirst(30);
        list.insertFirst(20);
        list.insertRecursion(80, 1);

        list.display();
    }
}

class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("End");
        System.out.println("Size: " + size);
    }


    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head; // for the 1st entry only.
        }
        size += 1;
    }

    public void insertRecursion(int val, int index) {
        head = insertRecursion(val, index, head);
    }

    private Node insertRecursion(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRecursion(val, index - 1, node.next);
        return node;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) { // single-argument constructor
            this.value = value;
        }
    }
}