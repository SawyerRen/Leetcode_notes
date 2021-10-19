package company.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q1748 {
    public int sumOfUnique(int[] nums) {
        int[] count = new int[101];
        int res = 0;
        for (int num : nums) {
            count[num]++;
            if (count[num] == 1) res += num;
            if (count[num] == 2) res -= num;
        }
        return res;
    }
}
