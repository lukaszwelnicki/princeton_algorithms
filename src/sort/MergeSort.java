package sort;

import static common.PrimitiveOperations.less;
import static common.PrimitiveOperations.merge;

public class MergeSort {

    private static final int CUTOFF = 7;

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi < lo + CUTOFF) {
            InsertionSort.sort(a);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        if (less(a[mid], a[mid + 1])) return;
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
}
