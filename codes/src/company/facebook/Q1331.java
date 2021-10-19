package company.facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : temp) {
            map.putIfAbsent(j, map.size() + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            temp[i] = map.get(arr[i]);
        }
        return temp;
    }
}
