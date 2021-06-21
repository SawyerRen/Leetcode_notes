package topics.array;

public class Q48 {
    public void rotate(int[][] matrix) {
        // 先坐下、右上翻折，再左右翻折
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int[] ints : matrix) {
            int left = 0, right = n - 1;
            while (left < right) {
                swap(ints, left, right);
                left++;
                right--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
