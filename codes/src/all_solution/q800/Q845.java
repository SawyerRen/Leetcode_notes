package all_solution.q800;

public class Q845 {
    int res = 0;

    public int longestMountain(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            helper(arr, i, i);
        }
        return res;
    }

    private void helper(int[] arr, int i, int j) {
        if (arr[i] <= arr[i - 1] || arr[j] <= arr[j + 1]) return;
        while (i > 0 && arr[i] > arr[i - 1]) {
            i--;
        }
        while (j < arr.length - 1 && arr[j] > arr[j + 1]) {
            j++;
        }
        res = Math.max(j - i + 1, res);
    }
}
