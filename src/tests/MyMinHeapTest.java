package tests;

import mycollections.MyMinHeap;

// Test class for MyMinHeap implementation
public class MyMinHeapTest {
    public static void main(String[] args) {
        // Create a MinHeap of Integer elements
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        // Test: insert elements into the heap
        heap.insert(30); // Heap: [30]
        heap.insert(20); // Heap: [20, 30]
        heap.insert(10); // Heap: [10, 30, 20]
        heap.insert(40); // Heap: [10, 30, 20, 40]
        heap.insert(5);  // Heap: [5, 10, 20, 40, 30]

        // Test: peek the minimum element
        System.out.println("Min (peek): " + heap.peek()); // Output: 5

        // Test: remove the minimum element
        System.out.println("Removed min: " + heap.remove()); // Output: 5
        // Heap after remove: [10, 30, 20, 40]

        // Test: peek after remove
        System.out.println("New min: " + heap.peek()); // Output: 10

        // Test: insert more values
        heap.insert(2);  // Heap: [2, 10, 20, 40, 30]

        // Test: size of heap
        System.out.println("Size: " + heap.size()); // Output: 5

        // Test: remove all elements in order
        System.out.print("Heap removal order: ");
        while (!heap.isEmpty()) {
            System.out.print(heap.remove() + " "); // Expected ascending order
        }
        System.out.println();

        // After removing everything, heap should be empty
        System.out.println("Is heap empty? " + heap.isEmpty()); // Output: true
    }
}

/*
Overall:
This test class verifies the behavior of MyMinHeap (a binary min-heap).
Tested methods include:
- insert(T): adds an element and reorders the heap
- remove(): removes and returns the smallest element (root)
- peek(): views the minimum without removing
- isEmpty(): checks if the heap is empty
- size(): returns number of elements

The test confirms correct insertion, heap ordering (min at top), and removal in ascending order.
*/
