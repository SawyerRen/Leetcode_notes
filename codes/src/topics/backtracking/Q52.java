package topics.backtracking;

public class Q52 {
    int count = 0;

    public int totalNQueens(int n) {
        int[] arr = new int[n];
        helper(arr, 0);
        return count;
    }

    private void helper(int[] arr, int row) {
        if (row == arr.length) {
            count++;
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[row] = i;
            if (valid(arr, row)) {
                helper(arr, row + 1);
            }
        }
    }

    private boolean valid(int[] arr, int row) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == arr[row] || Math.abs(arr[i] - arr[row]) == Math.abs(i - row)) return false;
        }
        return true;
    }
}
