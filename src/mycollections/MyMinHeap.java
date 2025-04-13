package mycollections;

import mycollections.MyArrayList;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    // Constructor
    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    // Adds an item and maintains heap property
    public void add(T item) {
        heap.addLast(item); // add to end
        heapifyUp(heap.size() - 1);
    }

    // Removes and returns the smallest item (root)
    public T remove() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        T min = heap.get(0); // root
        T last = heap.get(heap.size() - 1);

        heap.set(0, last);
        heap.removeLast(); // remove last

        heapifyDown(0);
        return min;
    }

    // Returns the minimum element without removing
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    // Returns true if heap is empty
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    // Returns number of elements in heap
    public int size() {
        return heap.size();
    }

    // Maintains heap order from bottom to top
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            T current = heap.get(index);
            T parentValue = heap.get(parent);

            if (current.compareTo(parentValue) < 0) {
                // Swap
                heap.set(index, parentValue);
                heap.set(parent, current);
                index = parent;
            } else break;
        }
    }

    // Maintains heap order from top to bottom
    private void heapifyDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest != index) {
                // Swap
                T temp = heap.get(index);
                heap.set(index, heap.get(smallest));
                heap.set(smallest, temp);
                index = smallest;
            } else break;
        }
    }

    public void insert(T i) {
    }
}
