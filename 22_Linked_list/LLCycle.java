// given a ll with cycle, return boolean true or false if ll has a cycle
//  1 -- 2 -- 3 -- 4  -- 5 --(points to 1st idx) 2
// Output = true

// use the fast, slow pointer approach

public class LLCycle {
    public static void main(String[] args) {
        System.out.println("Print all functions directly in leetcode, dont test them here");
    }
}

class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }

    public boolean hasCycle(Node head) {   // 1
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public int lengthOfCycle(Node head) {  // 2
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                // calculate the length, keep fast p there, iterate s till it reach f again,
                // keep counter to count
                Node temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);

                return length;
            }
        }

        return 0;
    }

    public int detectCycleStart(Node head) {  // 3
        int length = 0; 

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                length = lengthOfCycle(head);
                break;
            }
        }

        if(length == 0) {
            return 0;
        }

        // find the start node
        Node first = head;
        Node second = head;

        while(length > 0) {
            second = second.next;
            length -- ;
        }

        // keep moving both forward and they will meet at cycle start
        while(first != second) {
            first = first.next;
            second = second.next;
        }

        return first.value;

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
