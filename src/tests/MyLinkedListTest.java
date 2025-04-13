package tests;

import mycollections.MyLinkedList;

// Test class for MyLinkedList implementation
public class MyLinkedListTest {
    public static void main(String[] args) {
        // Create a new linked list of Integer elements
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // Test: add elements to the end of the list
        list.add(10); // [10]
        list.add(20); // [10, 20]
        list.add(30); // [10, 20, 30]

        // Test: insert element at index 1
        list.add(1, 15); // [10, 15, 20, 30]

        // Test: set value at index 2 to 25
        list.set(2, 25); // [10, 15, 25, 30]

        // Test: get element at index 2
        System.out.println("Element at index 2: " + list.get(2)); // Output: 25

        // Test: add element at the beginning
        list.addFirst(5); // [5, 10, 15, 25, 30]

        // Test: add element at the end
        list.addLast(35); // [5, 10, 15, 25, 30, 35]

        // Test: get first and last elements
        System.out.println("First: " + list.getFirst()); // Output: 5
        System.out.println("Last: " + list.getLast());   // Output: 35

        // Test: remove element at index 2
        list.remove(2); // Removes 15 → [5, 10, 25, 30, 35]

        // Test: remove first and last
        list.removeFirst(); // Removes 5 → [10, 25, 30, 35]
        list.removeLast();  // Removes 35 → [10, 25, 30]

        // Test: sort list
        list.add(5);
        list.add(40);
        list.sort(); // Should become [5, 10, 25, 30, 40]

        // Test: index methods
        System.out.println("Index of 25: " + list.indexOf(25));         // Output: 2
        System.out.println("Last index of 10: " + list.lastIndexOf(10)); // Output: 1

        // Test: check if element exists
        System.out.println("Exists 100: " + list.exists(100)); // false
        System.out.println("Exists 30: " + list.exists(30));   // true

        // Test: convert list to array and print
        Object[] array = list.toArray();
        System.out.print("Array: ");
        for (Object o : array) {
            System.out.print(o + " ");
        }
        System.out.println();

        // Test: clear list
        list.clear(); // List is now empty
        System.out.println("Size after clear: " + list.size()); // Output: 0
    }
}

/*
Overall:
This test class verifies the full functionality of MyLinkedList, including:
- Adding elements at various positions
- Removing elements from index, first, and last
- Setting and getting values
- Accessing first and last elements
- Sorting the list
- Searching with indexOf and lastIndexOf
- Checking if a value exists
- Converting the list to an array
- Clearing the list and checking its size

Each function is tested with representative values and printed to the console to validate correctness.
*/
