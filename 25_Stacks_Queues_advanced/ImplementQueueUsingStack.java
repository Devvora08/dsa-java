// implement queue functions using 2 stacks
// first will be main stack, 2nd as helper

import java.util.Stack;

public class ImplementQueueUsingStack{
    public static void main(String[] args) {
        // Stack<Integer> stack = new Stack<>();

        // stack.push(5);
        // System.out.println(stack.pop());
    }
}


// this is insertion efficient.
// Insert = O(1)
// Remove = O(N) 
class QueueImplementedByStack {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueImplementedByStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) {
        first.push(item);
    }

    public int remove() throws Exception {
        if(first.isEmpty()) {
            throw new Exception("Empty Queue(stack)");
        }
        while(!first.isEmpty()) {
            second.push(first.pop());
        }

        int removed = second.pop();
        while(!second.isEmpty()) {
            first.push(second.pop());
        }

        return removed;
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }
}
