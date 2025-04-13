package tests;

import mycollections.MyStack;

// Test class for MyStack implementation
public class MyStackTest {
    public static void main(String[] args) {
        // Create a stack of Integer values
        MyStack<Integer> stack = new MyStack<>();

        // Test: push elements onto the stack
        stack.push(10); // Stack: [10]
        stack.push(20); // Stack: [10, 20]
        stack.push(30); // Stack: [10, 20, 30]

        // Test: peek at the top element (should be 30)
        System.out.println("Top element (peek): " + stack.peek()); // Output: 30

        // Test: pop the top element (should remove 30)
        System.out.println("Popped: " + stack.pop()); // Output: 30
        // Stack: [10, 20]

        // Test: peek again after popping
        System.out.println("Top after pop: " + stack.peek()); // Output: 20

        // Test: push more values
        stack.push(40); // Stack: [10, 20, 40]
        stack.push(50); // Stack: [10, 20, 40, 50]

        // Test: size of the stack
        System.out.println("Size: " + stack.size()); // Output: 4

        // Test: pop all elements
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        // After all pops, the stack should be empty
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true
    }
}

/*
Overall:
This test class verifies the behavior of the stack data structure using MyStack.
Tested methods include:
- push(T): adds an element to the top
- pop(): removes the top element
- peek(): views the top element without removing
- isEmpty(): checks whether the stack is empty
- size(): returns the number of elements

The test simulates typical stack usage (LIFO) and prints the expected results to confirm correctness.
*/
