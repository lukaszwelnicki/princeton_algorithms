package stacksqueues;

public class DoubleStackQueue<T extends Comparable<T>> implements Queue<T> {
    private Stack<T> in = new ArrayStackVariableSize<>();
    private Stack<T> out = new ArrayStackVariableSize<>();

    @Override
    public void enqueue(T object) {
        in.push(object);
    }

    @Override
    public T dequeue() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        if (!out.isEmpty()) return out.pop();
        return null;
    }

    @Override
    public boolean isEmpty() {
        return out.isEmpty();
    }
}
