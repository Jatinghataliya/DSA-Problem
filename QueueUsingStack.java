import java.util.Stack;

class QueueUsingStack<T> {
    private final Stack<T> inStack;
    private final Stack<T> outStack;

    // Time Complexity:
    // enqueue() -> O(1)
    // dequeue() -> O(n) worst case (when outStack is empty and we move all elements)
    // peek()    -> O(n) worst case
    // isEmpty() -> O(1)
    // size()    -> O(1)
    //
    // Space Complexity:
    // O(n) overall for n elements stored in both stacks

    public QueueUsingStack() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void enqueue(T value) {
        inStack.push(value);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.peek();
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public int size() {
        return inStack.size() + outStack.size();
    }

    public static void main(String[] args) {
        QueueUsingStack<Integer> queue = new QueueUsingStack<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Queue size after dequeue: " + queue.size());
    }
}