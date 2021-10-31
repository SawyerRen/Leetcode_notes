package company.fbr3;

public class Q1060 {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getMissing(nums, mid) >= k) right = mid;
            else left = mid + 1;
        }
        return left - 1 + nums[0] + k;
    }

    int getMissing(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }
}
