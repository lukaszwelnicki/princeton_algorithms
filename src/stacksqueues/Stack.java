package stacksqueues;

public interface Stack<T> {
    void push(T object);

    T pop();

    boolean isEmpty();
}
