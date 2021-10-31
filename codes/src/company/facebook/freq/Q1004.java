package company.facebook.freq;

public class Q1004 {
    public int longestOnes(int[] nums, int k) {
        int i = 0, j = 0, res = 0, count = 0;
        while (j < nums.length) {
            if (nums[j] == 0) count++;
            while (count > k) {
                if (nums[i] == 0) count--;
                i++;
            }
            res = Math.max(j - i + 1, res);
            j++;
        }
        return res;
    }
}
