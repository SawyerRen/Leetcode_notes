package company.facebook;

public class Q674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1;
        int i = 0, j = 1;
        while (j < nums.length) {
            while (j < nums.length && nums[j - 1] < nums[j]) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j;
            j++;
        }
        return res;
    }
}
