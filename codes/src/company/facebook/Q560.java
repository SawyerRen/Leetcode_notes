package company.facebook;

import java.util.HashMap;
import java.util.Map;

public class Q560 {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }


    static public int subarraySumAllPositive(int[] nums, int k) {
        int i = 0, j = 0;
        int sum = 0, res = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum > k) {
                sum -= nums[i];
                i++;
            }
            if (sum == k) res++;
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(subarraySumAllPositive(nums, k));
    }
}
