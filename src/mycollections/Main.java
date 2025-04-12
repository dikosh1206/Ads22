package mycollections;

import tests.*;

// Main class to run all tests for the data structures
public class Main {
    public static void main(String[] args) {
        // Print a message to indicate the start of testing
        System.out.println("Running all structure tests...\n");

        // Run tests for MyArrayList
        System.out.println("Testing MyArrayList:");
        MyArrayListTest.main(null); // Call main method of MyArrayListTest
        System.out.println("\n----------------------------\n"); // Separator for clarity

        // Run tests for MyLinkedList
        System.out.println("Testing MyLinkedList:");
        MyLinkedListTest.main(null); // Call main method of MyLinkedListTest
        System.out.println("\n----------------------------\n"); // Separator

        // Run tests for MyStack
        System.out.println("Testing MyStack:");
        MyStackTest.main(null); // Call main method of MyStackTest
        System.out.println("\n----------------------------\n"); // Separator

        // Run tests for MyQueue
        System.out.println("Testing MyQueue:");
        MyQueueTest.main(null); // Call main method of MyQueueTest
        System.out.println("\n----------------------------\n"); // Separator

        // Run tests for MyMinHeap
        System.out.println("Testing MyMinHeap:");
        MyMinHeapTest.main(null); // Call main method of MyMinHeapTest

        // Print a final message after all tests are done
        System.out.println("\nAll tests completed!");
    }
}

/*
Overall:
This Main class acts as the entry point for the program.
It runs the test classes for all custom data structures:
- MyArrayList
- MyLinkedList
- MyStack
- MyQueue
- MyMinHeap

Each test verifies the correctness and functionality of the corresponding class.

By calling the main methods of test classes in sequence, this Main class allows full testing with a single run.
*/
