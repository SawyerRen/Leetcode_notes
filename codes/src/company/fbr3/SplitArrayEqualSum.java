package company.fbr3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArrayEqualSum {
    static List<int[]> splitArray(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) return null;
        int index = -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum * 2 == total) {
                index = i;
                break;
            }
        }
        if (index == -1) return null;
        int[] part1 = Arrays.copyOf(nums, index + 1);
        int[] part2 = Arrays.copyOfRange(nums, index + 1, nums.length);
        List<int[]> res = new ArrayList<>();
        res.add(part1);
        res.add(part2);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3};
        List<int[]> res = splitArray(nums);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
}
