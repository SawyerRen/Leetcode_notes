package company.fbr4.q900;

public class Q977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = nums.length - 1;
        int index = n - 1;
        while (left <= right) {
            int p1 = nums[left] * nums[left];
            int p2 = nums[right] * nums[right];
            if (p1 < p2) {
                res[index--] = p2;
                right--;
            } else {
                res[index--] = p1;
                left++;
            }
        }
        return res;
    }
}
