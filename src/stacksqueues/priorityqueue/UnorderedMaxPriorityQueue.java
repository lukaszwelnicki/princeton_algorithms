package stacksqueues.priorityqueue;


import static common.PrimitiveOperations.exch;
import static common.PrimitiveOperations.less;

public class UnorderedMaxPriorityQueue<T extends Comparable<T>> implements MaxPriorityQueue<T> {

    private T[] priorityQueue;
    private int size;

    public UnorderedMaxPriorityQueue(int capacity) {
        this.priorityQueue = (T[]) new Comparable[capacity];
    }

    @Override
    public void insert(T key) {
        priorityQueue[size++] = key;
    }

    @Override
    public T delete() {
        int maxIndex = getMaxIndex();
        exch(priorityQueue, maxIndex, size - 1);
        return priorityQueue[--size];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T max() {
        return priorityQueue[getMaxIndex()];
    }

    private int getMaxIndex() {
        int maxIndex = 0;
        for (int i = 1; i < size; i++) {
            if (less(priorityQueue[maxIndex], priorityQueue[i])) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
