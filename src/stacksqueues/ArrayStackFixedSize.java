package stacksqueues;

public class ArrayStackFixedSize<T> implements Stack<T> {

    private T[] objects;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public ArrayStackFixedSize(int capacity) {
        objects = (T[]) new Object[capacity];
    }

    @Override
    public void push(T object) {
        objects[N++] = object;
    }

    @Override
    public T pop() {
        T result = objects[--N];
        objects[N] = null;
        return result;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }
}
