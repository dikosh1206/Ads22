package mycollections;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    // Initial capacity of the array list
    private static final int INITIAL_CAPACITY = 10;

    // Internal array to store elements
    private Object[] elements;

    // Tracks the current number of elements in the list
    private int size;

    // Constructor to initialize the array with the initial capacity
    public MyArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // Adds an item to the end of the list
    @Override
    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    // Adds an item at a specific index
    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        ensureCapacity();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        size++;
    }

    // Sets the item at a specific index
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }

    // Adds an item to the beginning of the list
    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    // Adds an item to the end (same as add)
    @Override
    public void addLast(T item) {
        add(item);
    }

    // Returns the item at the specified index
    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    // Returns the first item in the list
    @Override
    public T getFirst() {
        return get(0);
    }

    // Returns the last item in the list
    @Override
    public T getLast() {
        return get(size - 1);
    }

    // Removes the item at the specified index
    @Override
    public T remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return null;
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    // Removes the first item
    @Override
    public void removeFirst() {
        remove(0);
    }

    // Removes the last item
    @Override
    public void removeLast() {
        remove(size - 1);
    }

    // Sorts the list using insertion sort (T must implement Comparable)
    @Override
    public void sort() {
        for (int i = 1; i < size; i++) {
            T key = get(i);
            int j = i - 1;
            while (j >= 0 && get(j).toString().compareTo(key.toString()) > 0) {
                set(j + 1, get(j));
                j--;
            }
            set(j + 1, key);
        }
    }

    // Returns the index of the first occurrence of the object
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    // Returns the index of the last occurrence of the object
    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    // Checks if the object exists in the list
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // Converts the list to a plain array
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(elements, 0, result, 0, size);
        return result;
    }

    // Clears the list
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // Returns the current number of elements
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    // Returns an iterator for the list
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                return (T) elements[index++];
            }
        };
    }

    // Ensures there's enough capacity in the array (doubles size if needed)
    private void ensureCapacity() {
        if (size == elements.length) {
            Object[] newArray = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
    }

    // Checks if index is valid for accessing elements
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);
    }

    // Checks if index is valid for adding elements (can be equal to size)
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);
    }
}

