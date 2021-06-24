package topics.two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []


Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 首先对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 由于数组是排序过的，如果第一个数已经大于0了，后面的数加上的和一定不可能等于0，直接结束循环
            if (nums[i] > 0) break;
            // 跳过重复的数
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 此时的目标值就是-nums[i]
            int target = -nums[i];
            // 用双指针找剩下的两个数
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l > i + 1 && nums[l] == nums[l - 1]) l++;
                    while (r < nums.length - 1 && nums[r] == nums[r + 1]) r--;
                } else {
                    if (nums[l] + nums[r] < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
