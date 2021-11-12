package company.fbr4.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q406 {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        for (int[] person : people) {
            list.add(person[1], person);
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
