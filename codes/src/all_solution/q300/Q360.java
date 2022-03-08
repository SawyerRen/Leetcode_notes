package all_solution.q300;

public class Q360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n - 1, index = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            int left = a * nums[i] * nums[i] + b * nums[i] + c;
            int right = a * nums[j] * nums[j] + b * nums[j] + c;
            if (a >= 0) {
                if (left < right) {
                    res[index--] = right;
                    j--;
                } else {
                    res[index--] = left;
                    i++;
                }
            } else {
                if (left < right) {
                    res[index++] = left;
                    i++;
                } else {
                    res[index++] = right;
                    j--;
                }
            }
        }
        return res;
    }
}
