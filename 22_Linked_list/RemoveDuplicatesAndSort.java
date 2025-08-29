// given a sorted linked list, remove all duplicates, and return sorted list
// 1 - 1 - 1 - 2 - 2 - 4 - 4
// 1 - 2 - 4

public class RemoveDuplicatesAndSort {
    public static void main(String[] args) {
         LL list = new LL();
        list.insertFirst(50);
        list.insertFirst(50);
        list.insertFirst(30);
        list.insertFirst(30);
        list.insertFirst(20);
        list.insertFirst(20);
        list.removeDuplicates();

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
            System.out.print(temp.val + " -> ");
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

    

    public void removeDuplicates() {
        Node node = head;
        while(node.next != null) {
            if(node.val == node.next.val) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
        tail.next = null;
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        // public Node(int val, Node next) {
        //     this.next = next;
        //     this.val = val;
        // }
    }
}
