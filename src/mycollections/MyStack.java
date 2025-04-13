package mycollections;

import mycollections.MyArrayList;

public class MyStack<T> {
    private final MyArrayList<T> list;

    // Constructor initializes the internal array list
    public MyStack() {
        list = new MyArrayList<>();
    }

    // Pushes an item onto the top of the stack
    public void push(T item) {
        list.addLast(item); // add to the end
    }

    // Pops the top item from the stack
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        T item = list.getLast(); // get last item
        list.removeLast();       // remove it
        return item;
    }

    // Returns the top item without removing it
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return list.getLast();
    }

    // Returns true if the stack is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Returns the number of items in the stack
    public int size() {
        return list.size();
    }
}
