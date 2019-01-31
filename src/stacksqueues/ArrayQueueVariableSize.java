package stacksqueues;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueueVariableSize<T> implements Queue<T> {
    private T[] objects;
    private int end = 0;
    private int start = 0;
    private int count = 0;

    @SuppressWarnings("unchecked")
    public ArrayQueueVariableSize() {
        objects = (T[]) new Object[2];
    }

    @Override
    public void enqueue(T object) {
        //double the size of the array when it gets full
        if (count == objects.length) resizeQueue(2 * objects.length);
        objects[end++] = object;
        //wrap-up
        if (end == objects.length) end = 0;
        count++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        T result = objects[start];
        objects[start] = null;
        count--;
        start++;
        if (start == objects.length) start = 0;
        //shrink the array when it gets 1/4 full
        if (count > 0 && count == objects.length / 4) resizeQueue(objects.length / 2);
        return result;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    private void resizeQueue(int capacity) {
        if (capacity <= count)
            throw new IllegalArgumentException("New capacity should be greater than number of elements");
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i < count; i++) {
            //the % operator is used due to wrap-up of the last elements going to the physical start of the array
            temp[i] = objects[(start + i) % objects.length];
        }
        objects = temp;
        start = 0;
        end = count;
    }
}
