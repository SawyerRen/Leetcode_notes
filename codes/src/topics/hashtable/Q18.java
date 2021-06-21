package topics.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int one = nums[i];
            int threeSum = target - one;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int two = nums[j];
                int twoSum = threeSum - two;
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == twoSum) {
                        List<Integer> integerList = Arrays.asList(one, two, nums[l], nums[r]);
                        res.add(integerList);
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;
                    } else if (nums[l] + nums[r] > twoSum) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
