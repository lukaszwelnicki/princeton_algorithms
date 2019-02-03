package sort;

import static sort.SortUtils.less;
import static sort.SortUtils.swap;

public class ShellSortKnuth {
    public static Comparable[] sort(Comparable[] sorted) {
        int N = sorted.length;
        int h = 1;

        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(sorted[j], sorted[j - h]); j -= h) {
                    swap(sorted, j, j - h);
                }
            }
            h = h / 3;
        }

        return sorted;
    }
}
