package all_solution.q400;

public class Q410 {
    public int splitArray(int[] nums, int m) {
        long sum = 0, max = nums[0];
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

    private boolean valid(int[] nums, long sum, int m) {
        int count = 1, cur = 0;
        for (int num : nums) {
            cur += num;
            if (cur > sum) {
                cur = num;
                count++;
            }
            if (count > m) return false;
        }
        return true;
    }
}
