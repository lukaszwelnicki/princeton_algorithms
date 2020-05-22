package sort;


import static common.PrimitiveOperations.less;
import static common.PrimitiveOperations.swap;

public class SelectionSort {
    public static Comparable[] sort(Comparable[] sorted) {
        for (int i = 0; i < sorted.length; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < sorted.length; j++) {
                if (less(sorted[j], sorted[smallestIndex])) {
                    smallestIndex = j;
                }
            }
            swap(sorted, i, smallestIndex);
        }
        return sorted;
    }
}
