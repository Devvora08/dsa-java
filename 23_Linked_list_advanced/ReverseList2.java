// Given the head of a singly linked list and two integers left and right where left <= right,
// reverse the nodes of the list from position left to position right, and return the reversed list.

// Input: head = [1,2,3,4,5], left = 2, right = 4
// Output: [1,4,3,2,5]

public class ReverseList2 {
    public static void main(String[] args) {

    }

}

class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    static Node reverseBetween(Node head, int left, int right) {
        if(left == right) return head;

        // skip the first left-1 nodes
        Node current = head;
        Node prev = null;
        for(int i = 0;current != null && i < left - 1; i++) {
            prev = current;
            current = current.next;
        }
        Node last = prev;
        Node newEnd = current;
        Node next = current.next;

        // reverse between left and right
        for (int i = 0;current != null && i < (right - left + 1); i++) {
            current.next = prev;
            prev = current;
            current = next;
            if(next != null) {
                next = next.next;
            }
        }

        if(last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        newEnd.next = current;
        return head;
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

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("End");
        System.out.println("Size: " + size);
    }

    private class Node {
        private int value;
        private Node next;

        // public Node(int value, Node next) {
        // this.value = value;
        // this.next = next;
        // }

        public Node(int value) { // single-argument constructor
            this.value = value;
        }
    }

}
