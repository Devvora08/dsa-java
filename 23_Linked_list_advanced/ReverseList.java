// reverse the given linked list 

public class ReverseList {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(50);
        list.insertFirst(40);
        list.insertFirst(30);
        list.insertFirst(20);
        list.insertFirst(10);
        list.display();
        System.out.println("Displaying not in place method now");
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

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head; // for the 1st entry only.
        }
        size += 1;
    }
    
    private void reverseList(Node node) {  // not in place, uses recursion
        if(node == tail) {
            head = tail;
            return;
        }
        reverseList(node.next);

        tail.next = node;
        tail = node;
        tail.next = null;
    }

    public void reverse() {  // this is in place reversal
        if(size < 2) {
            return;
        }

        Node prev = null;
        Node present = head;
        Node next = present.next;

        while(present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if(next != null) {
                next = next.next;
            }
        }

        head = prev;
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

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value) { // single-argument constructor
            this.value = value;
        }
    }
}

