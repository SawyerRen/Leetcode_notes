package all_solution.q100;

import java.util.Arrays;
import java.util.Stack;

public class Q85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix[0].length;
        int[] dp = new int[n];
        int res = getArea(dp);
        for (char[] row : matrix) {
            for (int j = 0; j < n; j++) {
                dp[j] = row[j] == '1' ? dp[j] + 1 : 0;
            }
            res = Math.max(res, getArea(dp));
        }
        return res;
    }

    private int getArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= heights.length; i++) {
            int height = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && height < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                res = Math.max(res, w * h);
            }
            stack.push(i);
        }
        return res;
    }
}
