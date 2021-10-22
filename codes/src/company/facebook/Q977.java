package company.facebook;

public class Q977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = nums.length - 1;
        int index = n - 1;
        while (i <= j) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                res[index--] = nums[j] * nums[j];
                j--;
            } else {
                res[index--] = nums[i] * nums[i];
                i++;
            }
        }
        return res;
    }
}
