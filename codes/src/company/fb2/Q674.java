package company.fb2;

public class Q674 {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int count = 1;
            while (i + 1 < nums.length && nums[i + 1] > nums[i]) {
                count++;
                i++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
