package topics.binarysearch;

public class Q410 {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = nums[0];
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        long left = max, right = sum;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (valid(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int) left;
    }

    private boolean valid(int[] nums, long maxSum, int m) {
        int curSum = 0;
        int count = 1;
        for (int num : nums) {
            curSum += num;
            if (curSum > maxSum) {
                count++;
                curSum = num;
                if (count > m) return false;
            }
        }
        return true;
    }
}
