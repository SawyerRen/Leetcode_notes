package company.facebook;

public class Q1060 {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        if (getMissingCount(nums, nums.length - 1) < k) {
            return nums[nums.length - 1] + k -getMissingCount(nums, nums.length - 1);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int missingCount = getMissingCount(nums, mid);
            if (missingCount >= k) right = mid;
            else left = mid + 1;
        }
        return nums[left - 1] + k - getMissingCount(nums, left - 1);
    }

    int getMissingCount(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }
}
