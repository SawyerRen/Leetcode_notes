package all_solution.q0;

public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeftBound(nums, target);
        int right = findLeftBound(nums, target + 1);
        if (left >= nums.length || nums[left] != target) return new int[]{-1, -1};
        return new int[]{left, right - 1};
    }

    private int findLeftBound(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
