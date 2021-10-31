package company.fbr3;

public class Q674 {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 1;
            while (i + 1 < nums.length && nums[i + 1] > nums[i]) {
                i++;
                len++;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
