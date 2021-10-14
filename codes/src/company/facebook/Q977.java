package company.facebook;

public class Q977 {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1;
        int n = nums.length;
        int[] res = new int[n];
        int index = n - 1;
        while (i <= j) {
            int s1 = nums[i] * nums[i];
            int s2 = nums[j] * nums[j];
            if (s1 > s2) {
                res[index--] = s1;
                i++;
            } else {
                res[index--] = s2;
                j--;
            }
        }
        return res;
    }
}
