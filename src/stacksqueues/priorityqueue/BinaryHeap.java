package stacksqueues.priorityqueue;

import static common.PrimitiveOperations.exch;
import static common.PrimitiveOperations.less;

public class BinaryHeap<T extends Comparable<T>> implements MaxPriorityQueue<T> {
    private T[] priorityQueue;
    private int size;

    public BinaryHeap(int capacity) {
        this.priorityQueue = (T[]) new Comparable[capacity + 1];
    }

    @Override
    public T max() {
        return priorityQueue[1];
    }

    @Override
    public void insert(T key) {
        priorityQueue[++size] = key;
        swim(size);
    }

    @Override
    public T delete() {
        T max = priorityQueue[1];
        exch(priorityQueue, 1, size--);
        sink(1);
        priorityQueue[size + 1] = null;
        return max;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void sink(int index) {
        while (2 * index < size) {
            int leafIndex = 2 * index;
            if (leafIndex < size && less(priorityQueue[leafIndex], priorityQueue[leafIndex + 1])) {
                leafIndex++;
            }
            if (!less(priorityQueue[index], priorityQueue[leafIndex])) {
                break;
            }
            exch(priorityQueue, index, leafIndex);
            index = leafIndex;
        }
    }

    private void swim(int index) {
        while (index > 1 && less(priorityQueue[index / 2], priorityQueue[index])) {
            exch(priorityQueue, index, index / 2);
            index = index / 2;
        }
    }
}
