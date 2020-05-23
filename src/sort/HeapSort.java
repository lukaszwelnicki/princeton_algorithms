package sort;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

import static common.PrimitiveOperations.exch;
import static common.PrimitiveOperations.less;

public class HeapSort {
    public static void sort(Comparable[] sorted) {
        int size = sorted.length;
        for (int i = size / 2; i >= 1; i--) {
            sink(sorted, i, size);
        }
        while (size > 1) {
            exch(sorted, 0, size - 1);
            sink(sorted, 1, --size);
        }
    }

    private static void sink(Comparable[] heap, int index, int size) {
        while (2 * index < size) {
            int leafIndex = 2 * index;
            if (leafIndex < size && less(heap[leafIndex], heap[leafIndex + 1])) {
                leafIndex++;
            }
            if (!less(heap[index], heap[leafIndex])) {
                break;
            }
            exch(heap, index, leafIndex);
            index = leafIndex;
        }
    }

    private static void swim(Comparable[] heap, int index) {
        while (index > 1 && less(heap[index / 2], heap[index])) {
            exch(heap, index, index / 2);
            index = index / 2;
        }
    }
}
