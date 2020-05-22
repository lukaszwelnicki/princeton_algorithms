package stacksqueues.priorityqueue;

public interface PriorityQueue<T extends Comparable<T>> {

    void insert(T key);

    T delete();

    boolean isEmpty();

    int size();
}
