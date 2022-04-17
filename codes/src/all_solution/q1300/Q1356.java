package all_solution.q1300;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q1356 {
    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        list.sort((a, b) -> {
            int i = getBits(a);
            int j = getBits(b);
            if (i == j) return a - b;
            return i - j;
        });
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int getBits(Integer i) {
        int count = 0;
        while (i != 0) {
            count += (i & 1);
            i >>>= 1;
        }
        return count;
    }
}
