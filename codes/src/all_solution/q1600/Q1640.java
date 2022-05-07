package all_solution.q1600;

import java.util.HashMap;
import java.util.Map;

public class Q1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int[] piece = pieces[map.get(arr[i])];
                for (int num : piece) {
                    if (arr[i] != num) return false;
                    i++;
                }
                i--;
            } else {
                return false;
            }
        }
        return true;
    }
}
