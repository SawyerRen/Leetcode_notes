package company.facebook;

public class Q1060 {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int missingNum = nums[n - 1] - nums[0] - n + 1;
        if (missingNum < k) return nums[n - 1] + k - missingNum;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int missing = nums[mid] - nums[left] - (mid - left);
            if (missing >= k) {
                right = mid;
            } else {
                k -= missing;
                left = mid;
            }
        }
        return nums[left] + k;
    }
}
