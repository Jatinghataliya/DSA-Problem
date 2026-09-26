import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue<T> {
    private final Queue<T> queue;

    // Time Complexity:
    // push()  -> O(n) because each existing element is rotated to maintain stack order
    // pop()   -> O(1)
    // peek()  -> O(1)
    // isEmpty()-> O(1)
    // size()  -> O(1)
    //
    // Space Complexity:
    // O(n) overall for storing n elements in the queue

    public StackUsingQueue() {
        this.queue = new LinkedList<>();
    }

    public void push(T value) {
        queue.offer(value);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue.poll();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public static void main(String[] args) {
        StackUsingQueue<Integer> stack = new StackUsingQueue<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack size after pop: " + stack.size());
    }
}