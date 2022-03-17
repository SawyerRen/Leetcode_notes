package all_solution.q700;

public class Q713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0, j = 0, res = 0, product = 1;
        while (j < nums.length) {
            product *= nums[j];
            while (i < j && product >= k) {
                product /= nums[i];
                i++;
            }
            if (product < k) {
                res += j - i + 1;
            }
            j++;
        }
        return res;
    }
}
