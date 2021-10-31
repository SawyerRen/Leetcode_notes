package company.facebook.freq;

public class Q977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int index = n - 1;
        int i = 0, j = n - 1;
        while (i <= j) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                res[index--] = nums[i] * nums[i];
                i++;
            } else {
                res[index--] = nums[j] * nums[j];
                j--;
            }
        }
        return res;
    }
}
