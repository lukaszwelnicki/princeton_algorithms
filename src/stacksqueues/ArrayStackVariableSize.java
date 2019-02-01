package stacksqueues;


import java.util.Arrays;
import java.util.Iterator;

public class ArrayStackVariableSize<T> implements Stack<T>, Iterable<T> {
    private T[] objects;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public ArrayStackVariableSize() {
        objects = (T[]) new Object[1];
    }

    @Override
    public void push(T object) {
        //double the size of the array when it gets full
        if (N == objects.length) resizeStack(2 * objects.length);
        objects[N++] = object;
    }

    @Override
    public T pop() {
        T result = objects[--N];
        objects[N] = null;
        //shrink the array when it gets 1/4 full
        if (N > 0 && N == objects.length / 4) resizeStack(objects.length / 2);
        return result;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private void resizeStack(int capacity) {
        objects = Arrays.copyOf(objects, capacity);
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return objects[--i];
        }
    }

}
