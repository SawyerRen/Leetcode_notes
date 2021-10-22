package company.facebook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1331 {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < temp.length; i++) {
            map.putIfAbsent(temp[i], map.size() + 1);
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}
