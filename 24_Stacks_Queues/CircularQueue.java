public class CircularQueue {
    public static void main(String[] args) throws Exception {
        CircularQ queue = new CircularQ(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);

        queue.display();
        System.out.println(queue.remove());
        queue.display();
    }
}

class CircularQ {
    protected int[] data;
    private static final int DEFAULT_SIZE = 5;

    protected int end = 0;
    protected int front = 0;
    private int size = 0;

    public CircularQ() {
        this(DEFAULT_SIZE);
    }

    public CircularQ(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }

        data[end] = item;
        end = (end + 1) % data.length;
        size++;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }

        int removed = data[front++];
        front = front % data.length;
        size--;

        return removed;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Empty queue");
            return;
        }
        int i = front;
        do {
            System.out.print(data[i] + " ");
            i++;
            i = i % data.length;
        } while(i != end);
        System.out.println("END");
    }

    public boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

class DynamicQueue extends CircularQ{
    public DynamicQueue() {
        super();
    }

    public DynamicQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) {
        if (this.isFull()) {
            // double array size
            int[] temp = new int[data.length * 2];

            // copy previous arr items in temp
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            end = data.length;
            data = temp;
        }
        return super.insert(item);
    }
}
