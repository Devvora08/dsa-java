public class MergeSortedLists {
    public static void main(String[] args) {
        LL first = new LL();
        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(5);

        LL second = new LL();
        second.insertLast(2);
        second.insertLast(4);
        second.insertLast(6);

        LL merged = merge(first, second);
        merged.display();
    }

    public static LL merge(LL first, LL second) {
        LL.Node f = first.head;
        LL.Node s = second.head;
        LL ans = new LL();

        while (f != null && s != null) {
            if (f.val < s.val) {
                ans.insertLast(f.val);
                f = f.next;
            } else {
                ans.insertLast(s.val);
                s = s.next;
            }
        }

        while (f != null) {
            ans.insertLast(f.val);
            f = f.next;
        }

        while (s != null) {
            ans.insertLast(s.val);
            s = s.next;
        }

        return ans;
    }
}

class LL {
    Node head;
    Node tail;
    int size;

    LL() {
        size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        if (tail == null) {
            insertFirst(val);
            return;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("End | Size: " + size);
    }

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}
