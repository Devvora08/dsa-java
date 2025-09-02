public class CustomeStack {
    public static void main(String[] args) throws Exception {
        CStack stack = new CStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(406);
        stack.push(402);
        System.out.println(stack.pop());
    }
}

class CStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 5;

    int ptr = -1;

    public CStack() {
        this(DEFAULT_SIZE);
    }

    public CStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) {
        if (isFull()) {
            System.out.println("Stack Full");
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot pop from empty stack");
        }

        int removed = data[ptr];
        ptr--;
        return removed;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot pop from empty stack");
        }
        return data[ptr];
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    private boolean isEmpty() {
        return ptr == -1;
    }
}

class DynamicStack extends CStack {
    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) {
        if (this.isFull()) {
            // double array size
            int[] temp = new int[data.length * 2];

            // copy previous arr items in temp
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
        }

        return super.push(item);
    }
}