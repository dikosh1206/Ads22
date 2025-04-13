package mycollections;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    // Node class for doubly linked list
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    // Head (first node), tail (last node), and size of the list
    private MyNode head;
    private MyNode tail;
    private int size;

    // Constructor initializes an empty list
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Adds an item to the end
    @Override
    public void add(T item) {
        addLast(item);
    }

    // Adds an item at a specific index
    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            MyNode newNode = new MyNode(item);
            MyNode current = getNode(index);
            MyNode prev = current.prev;

            prev.next = newNode;
            newNode.prev = prev;

            newNode.next = current;
            current.prev = newNode;

            size++;
        }
    }

    // Sets the value at a specific index
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        getNode(index).data = item;
    }

    // Adds an item to the front
    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Adds an item to the end
    @Override
    public void addLast(T item) {
        MyNode newNode = new MyNode(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Gets the item at a specific index
    @Override
    public T get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    // Gets the first item
    @Override
    public T getFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        return head.data;
    }

    // Gets the last item
    @Override
    public T getLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        return tail.data;
    }

    // Removes the item at a specific index
    @Override
    public T remove(int index) {
        checkIndex(index);
        MyNode toRemove = getNode(index);
        removeNode(toRemove);
        return null;
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    // Removes the first item
    @Override
    public void removeFirst() {
        if (head == null) throw new IllegalStateException("List is empty");
        removeNode(head);
    }

    // Removes the last item
    @Override
    public void removeLast() {
        if (tail == null) throw new IllegalStateException("List is empty");
        removeNode(tail);
    }

    // Sorts the list using insertion sort (T must implement Comparable)
    @Override
    public void sort() {
        if (size < 2) return;
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

    // Returns index of first occurrence
    @Override
    public int indexOf(Object object) {
        MyNode current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(object)) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    // Returns index of last occurrence
    @Override
    public int lastIndexOf(Object object) {
        MyNode current = tail;
        int index = size - 1;
        while (current != null) {
            if (current.data.equals(object)) return index;
            current = current.prev;
            index--;
        }
        return -1;
    }

    // Checks if an element exists
    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    // Converts to an array
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    // Clears the list
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    // Returns the current size
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

    // Returns an iterator over the list
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    // Helper: get node by index
    private MyNode getNode(int index) {
        checkIndex(index);
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    // Helper: remove a node
    private void removeNode(MyNode node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

        size--;
    }

    // Helper: check if index is valid for get/set/remove
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);
    }

    // Helper: check if index is valid for add
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);
    }
}

//The MyLinkedList<T> class is a custom implementation of a doubly linked list in Java that implements the MyList<T> interface. It maintains elements using nodes, where each node stores a reference to the previous and next node, as well as the data itself.