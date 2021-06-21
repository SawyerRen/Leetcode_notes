package topics.binarysearch;

public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        int l1 = findLeftBound(nums, target);
        int l2 = findLeftBound(nums, target + 1);
        if (l1 >= nums.length || nums[l1] != target) return new int[]{-1, -1};
        return new int[]{l1, l2 - 1};
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
