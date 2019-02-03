package sort;

public class SortUtils {
    static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    static void swap(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
