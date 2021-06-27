package topics.binarysearch;

public class Q154 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[right]) return nums[left];
            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            if (nums[mid] < nums[right] || nums[mid] < nums[left]) {
                right = mid;
            } else if (nums[mid] > nums[right] || nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                left++;
                right--;
            }
        }
        return nums[left];
    }
}
