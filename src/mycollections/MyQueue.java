package mycollections;

public class MyQueue<T> {
    private final MyLinkedList<T> list = new MyLinkedList<>();

    // Constructor initializes the internal linked list
    public MyQueue() {
    }

    // Adds an item to the end (enqueue)
    public void enqueue(T item) {
        list.addLast(item);
    }

    // Removes and returns the first item (dequeue)
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    // Returns the first item without removing it
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        return list.getFirst();
    }

    // Returns true if the queue is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Returns the number of elements in the queue
    public int size() {
        return list.size();
    }
}
