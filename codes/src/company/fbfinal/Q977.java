package company.fbfinal;

public class Q977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0, j = nums.length - 1, index = nums.length - 1;
        while (i <= j) {
            int s1 = nums[i] * nums[i], s2 = nums[j] * nums[j];
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
