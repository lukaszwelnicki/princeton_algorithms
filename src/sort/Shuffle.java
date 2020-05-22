package sort;

import java.util.concurrent.ThreadLocalRandom;

import static common.PrimitiveOperations.swap;

public class Shuffle {
    public static Object[] shuffle(Object[] items) {
        for (int i = 0; i < items.length; i++) {
            int r = ThreadLocalRandom.current().nextInt(i + 1);
            swap(items, i, r);
        }
        return items;
    }
}
