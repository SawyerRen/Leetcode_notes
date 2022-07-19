package ng2022.oa.citadel;

import java.util.Map;

public class KSubArrays {

    private static int solution(int[] nums, int k) {
        int i = 0, j = 0, res = 0;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= k) {
                sum -= nums[i++];
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
