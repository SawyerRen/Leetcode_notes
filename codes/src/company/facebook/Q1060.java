package company.facebook;

public class Q1060 {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        if (k > getMissing(nums, n - 1)) {
            return nums[n - 1] + k - getMissing(nums, n - 1);
        }
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getMissing(nums, mid) >= k) right = mid;
            else left = mid + 1;
        }
        return nums[left - 1] + k - getMissing(nums, left - 1);
    }

    private int getMissing(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }
}
