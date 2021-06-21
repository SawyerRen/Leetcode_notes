package topics.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Q51_2 {
    public List<List<String>> solveNQueens(int n) {
        int[] arr = new int[n];
        List<List<String>> res = new ArrayList<>();
        helper(res, arr, 0);
        return res;
    }

    private void helper(List<List<String>> res, int[] arr, int row) {
        if (row >= arr.length) {
            res.add(covert2List(arr));
            return;
        }
        for (int col = 0; col < arr.length; col++) {
            arr[row] = col;
            if (valid(arr, row)) {
                helper(res, arr, row + 1);
            }
        }
    }

    private boolean valid(int[] arr, int row) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == arr[row] || Math.abs(i - row) == Math.abs(arr[i] - arr[row])) {
                return false;
            }
        }
        return true;
    }

    private List<String> covert2List(int[] arr) {
        List<String> list = new ArrayList<>();
        for (int col : arr) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (i == col) builder.append('Q');
                else builder.append('.');
            }
            list.add(builder.toString());
        }
        return list;
    }
}
