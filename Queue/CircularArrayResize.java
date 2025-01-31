// The queue should have a fixed initial size, but it should dynamically resize
// (double its capacity) if it becomes full during enqueue operations.

package Queue;

public class CircularArrayResize {
    private int queue[];
    private int front;
    private int rear;
    private int size;

    // Constructor with initial size
    public CircularArrayResize(int initialCapacity) {
        queue = new int[initialCapacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Method to enqueue an element
    public void enqueue(int value) {
        if (size == queue.length) {
            // Resize the queue if it is full
            resize();
        }

        queue[rear] = value;
        rear = (rear + 1) % queue.length; // Wrap around
        size++;
    }

    // Method to dequeue an element
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int value = queue[front];
        front = (front + 1) % queue.length; // Wrap around
        size--;
        return value;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the front element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    // Method to resize the queue
    private void resize() {
        int newCapacity = queue.length * 2;
        int[] newQueue = new int[newCapacity];

        // Copy elements from the old queue to the new queue
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }

        queue = newQueue;
        front = 0;
        rear = size;
    }

    // Method to get the current size of the queue
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CircularArrayResize queue = new CircularArrayResize(3); // Initial capacity of 3

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Dequeued: " + queue.dequeue()); // Should dequeue 10
        queue.enqueue(40); // Should trigger resizing

        System.out.println("Front element: " + queue.peek()); // Should be 20
        System.out.println("Queue size: " + queue.size()); // Should be 3
    }
}
