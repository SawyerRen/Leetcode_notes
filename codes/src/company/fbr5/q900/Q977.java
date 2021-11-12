package company.fbr5.q900;

public class Q977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0, j = nums.length - 1;
        int index = nums.length - 1;
        while (i <= j) {
            int s1 = nums[i] * nums[i], s2 = nums[j] * nums[j];
            if (s1 < s2) {
                res[index--] = s2;
                j--;
            } else {
                res[index--] = s1;
                i++;
            }
        }
        return res;
    }
}
