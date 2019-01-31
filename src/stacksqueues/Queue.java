package stacksqueues;

public interface Queue<T> {
    void enqueue(T object);

    T dequeue();

    boolean isEmpty();
}
