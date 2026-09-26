class Stack<T> {
    private T[] elements;
    private int top = -1;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.top = -1;
    }

    public void push(T item) {
        if (top < elements.length - 1) {
            elements[++top] = item;
        } else {
            throw new RuntimeException("Stack overflow");
        }
    }

    public T pop() {
        if (top >= 0) {
            T item = elements[top];
            elements[top--] = null; // Help GC
            return item;
        } else {
            throw new RuntimeException("Stack underflow");
        }
    }

    public T peek() {
        if (top >= 0) {
            return elements[top];
        } else {
            throw new RuntimeException("Stack is empty");
        }
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

class StackUsingArray {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack size after pop: " + stack.size());
    }
}