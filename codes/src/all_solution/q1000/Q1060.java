package all_solution.q1000;

public class Q1060 {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countMissing(nums, mid);
            if (count >= k) right = mid;
            else left = mid + 1;
        }
        return nums[left - 1] + k - countMissing(nums, left - 1);
    }

    private int countMissing(int[] nums, int index) {
        return nums[index] - nums[0] - index;
    }
}
