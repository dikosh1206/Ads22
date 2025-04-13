package mycollections;

import java.util.Iterator;

/**
 * Generic List interface for custom data structures.
 */
public interface MyList<T> {

    void add(T element);           // Add element at end
    void add(int index, T element); // Add element at specific index

    // Adds an item to the beginning of the list
    void addFirst(T item);

    // Adds an item to the end
    void addLast(T item);

    T get(int index);              // Get element at index
    void set(int index, T element); // Replace element at index

    // Returns the first item in the list
    T getFirst();

    // Returns the last item in the list
    T getLast();

    T remove(int index);           // Remove element by index
    boolean remove(T element);     // Remove first occurrence of element
    int size();                    // Return size of list
    boolean isEmpty();             // Check if list is empty
    boolean contains(T element);  // Check if element exists

    // Removes the first item
    void removeFirst();

    // Removes the last item
    void removeLast();

    // Sorts the list using insertion sort (T must implement Comparable)
    void sort();

    // Returns the index of the first occurrence of the object
    int indexOf(Object object);

    // Returns the index of the last occurrence of the object
    int lastIndexOf(Object object);

    // Checks if the object exists in the list
    boolean exists(Object object);

    // Converts the list to a plain array
    Object[] toArray();

    void clear();                  // Clear list

    // Returns an iterator for the list
    Iterator<T> iterator();
}

