package sort;

import static common.PrimitiveOperations.merge;

public class MergeSortBottomUp {

    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int size = 1; size < N; size += size) {
            for (int lo = 0; lo < N - size; lo += size + size) {
                merge(a, aux, lo , lo + size - 1, Math.min(lo + size + size - 1, N - 1));
            }
        }
    }

}
