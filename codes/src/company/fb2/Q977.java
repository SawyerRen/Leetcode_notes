package company.fb2;

public class Q977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n - 1;
        int index = n - 1;
        while (i <= j) {
            int square1 = nums[i] * nums[i];
            int square2 = nums[j] * nums[j];
            if (square1 > square2) {
                res[index--] = square1;
                i++;
            } else {
                res[index--] = square2;
                j--;
            }
        }
        return res;
    }
}
