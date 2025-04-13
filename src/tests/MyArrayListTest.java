package tests;

import mycollections.MyArrayList;
import mycollections.MyList;

// Test class for MyArrayList implementation
public class MyArrayListTest {
    public static void main(String[] args) {
        // Create a new list of Integer elements
        MyList<Integer> list = new MyArrayList<>();

        // Test: add elements to the end of the list
        list.add(10); // [10]
        list.add(20); // [10, 20]
        list.add(30); // [10, 20, 30]

        // Test: insert element at index 1
        list.add(1, 15); // [10, 15, 20, 30]

        // Test: replace value at index 2 with 25
        list.set(2, 25); // [10, 15, 25, 30]

        // Test: get element at index 2
        System.out.println("Element at index 2: " + list.get(2)); // Output: 25

        // Test: add element to the beginning of the list
        list.addFirst(5); // [5, 10, 15, 25, 30]

        // Test: add element to the end of the list
        list.addLast(35); // [5, 10, 15, 25, 30, 35]

        // Test: get the first element
        System.out.println("First: " + list.getFirst()); // Output: 5

        // Test: get the last element
        System.out.println("Last: " + list.getLast()); // Output: 35

        // Test: remove element at index 2
        list.remove(2); // Removes 15 → [5, 10, 25, 30, 35]

        // Test: remove the first element
        list.removeFirst(); // Removes 5 → [10, 25, 30, 35]

        // Test: remove the last element
        list.removeLast(); // Removes 35 → [10, 25, 30]

        // Test: sort the list
        list.add(5);    // [10, 25, 30, 5]
        list.add(40);   // [10, 25, 30, 5, 40]
        list.sort();    // After sorting: [5, 10, 25, 30, 40]

        // Test: get the index of element 25
        System.out.println("Index of 25: " + list.indexOf(25)); // Output: 2

        // Test: get the last index of 10 (only once so same as indexOf)
        System.out.println("Last index of 10: " + list.lastIndexOf(10)); // Output: 1

        // Test: check existence of elements
        System.out.println("Exists 100: " + list.exists(100)); // Output: false
        System.out.println("Exists 30: " + list.exists(30));   // Output: true

        // Test: convert list to array and print
        Object[] arr = list.toArray();
        System.out.print("Array: ");
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();

        // Test: clear the list
        list.clear(); // List is now empty
        System.out.println("Size after clear: " + list.size()); // Output: 0
    }
}

/*
Overall:
This test class validates all core functionalities of MyArrayList, including:
- Adding elements (at the end, beginning, and specific index)
- Removing elements (by index, from beginning, from end)
- Accessing and updating elements
- Getting first and last elements
- Sorting the list
- Finding index of elements
- Checking if an element exists
- Converting the list to an array
- Clearing the list

Each method is tested with sample values and printed to the console to verify correctness.
*/
