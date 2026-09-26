class Queue<T> {
    private T[] elements;
    private int front = 0;
    private int rear = -1;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public Queue(int capacity) {
        this.elements = (T[]) new Object[capacity];
    }

    public void enqueue(T item) {
        if (size < elements.length) {
            rear = (rear + 1) % elements.length;
            elements[rear] = item;
            size++;
        } else {
            throw new RuntimeException("Queue overflow");
        }
    }

    public T dequeue() {
        if (size > 0) {
            T item = elements[front];
            elements[front] = null; // Help GC
            front = (front + 1) % elements.length;
            size--;
            return item;
        } else {
            throw new RuntimeException("Queue underflow");
        }
    }

    public T peek() {
        if (size > 0) {
            return elements[front];
        } else {
            throw new RuntimeException("Queue is empty");
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

class QueueUsingArray {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Front element: " + queue.peek());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Queue size after dequeue: " + queue.size());
    }
}