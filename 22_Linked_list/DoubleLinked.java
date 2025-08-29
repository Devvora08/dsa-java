public class DoubleLinked {
    public static void main(String[] args) {
        DoubleLinked outer = new DoubleLinked(); // create outer
        DoubleList list = outer.new DoubleList(); // create inner from outer

        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertLast(5);
        list.idxInsert(2, 25);

        list.display();
    }

    class DoubleList {
        private Node head;

        public void insertFirst(int val) {
            Node node = new Node(val);
            node.next = head;
            node.prev = null;
            if (head != null) {
                head.prev = node;
            }

            head = node;
        }

        public void insertLast(int val) {
            Node temp = head;
            Node node = new Node(val);
            node.next = null;

            if (head == null) {
                node.prev = null;
                head = node;
                return;
            }
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = node;
            node.prev = temp;

        }

        public void idxInsert(int afterIdx, int val) {
            Node present = get(afterIdx);
            if(present == null) {
                System.out.println("node doesnt exists");
                return;
            }

            Node node = new Node(val);
            node.next = present.next;
            present.next = node;
            node.prev = present;
            if(node.next != null) {
                node.next.prev = node;
            }
        
        }

        public Node get(int index) {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }

            return node;
        }

        public void display() {
            Node node = head;
            Node last = null;
            while (node != null) {
                System.out.print(node.value + " -> ");
                last = node;
                node = node.next;
            }
            System.out.println("End");

            while (last != null) {
                System.out.print(last.value + "=>");
                last = last.prev;
            }
            System.out.println("Start");
        }

        private class Node {
            private int value;
            private Node next;
            private Node prev;

            public Node(int value) {
                this.value = value;
            }

            // public Node(int value, Node next, Node prev) {
            //     this.value = value;
            //     this.next = next;
            //     this.prev = prev;
            // }
        }
    }
}
