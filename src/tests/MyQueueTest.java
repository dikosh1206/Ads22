package tests;

import mycollections.MyQueue;

// Test class for MyQueue implementation
public class MyQueueTest {
    public static void main(String[] args) {
        // Create a queue of Integer values
        MyQueue<Integer> queue = new MyQueue<>();

        // Test: enqueue elements into the queue
        queue.enqueue(10); // Queue: [10]
        queue.enqueue(20); // Queue: [10, 20]
        queue.enqueue(30); // Queue: [10, 20, 30]

        // Test: peek at the front element (should be 10)
        System.out.println("Front element (peek): " + queue.peek()); // Output: 10

        // Test: dequeue the front element (should remove 10)
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 10
        // Queue: [20, 30]

        // Test: peek again after dequeue
        System.out.println("Front after dequeue: " + queue.peek()); // Output: 20

        // Test: enqueue more elements
        queue.enqueue(40); // Queue: [20, 30, 40]
        queue.enqueue(50); // Queue: [20, 30, 40, 50]

        // Test: size of the queue
        System.out.println("Size: " + queue.size()); // Output: 4

        // Test: dequeue all elements
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        // After all dequeues, the queue should be empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: true
    }
}

/*
Overall:
This test class verifies the behavior of the queue data structure using MyQueue.
Tested methods include:
- enqueue(T): adds an element to the end (tail)
- dequeue(): removes the front (head) element
- peek(): views the front element without removing
- isEmpty(): checks whether the queue is empty
- size(): returns the number of elements in the queue

The test simulates FIFO behavior (first-in, first-out) and prints the results to verify correctness.
*/

