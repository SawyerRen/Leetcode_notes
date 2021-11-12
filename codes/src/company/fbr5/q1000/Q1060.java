package company.fbr5.q1000;

public class Q1060 {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (getMissing(nums, mid) >= k) right = mid;
            else left = mid + 1;
        }
        return nums[left - 1] + k - getMissing(nums, left - 1);
    }

    int getMissing(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }
}
