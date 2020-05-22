package stacksqueues.priorityqueue;

public interface MaxPriorityQueue<T extends Comparable<T>> extends PriorityQueue<T> {

    T max();

}
