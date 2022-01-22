package all_solution.q0;

import java.util.Arrays;
import java.util.Stack;

public class Q85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            dp[j] = matrix[0][j] == '1' ? 1 : 0;
        }
        int res = getArea(dp);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j] = matrix[i][j] == '0' ? 0 : dp[j] + 1;
            }
            res = Math.max(res, getArea(dp));
        }
        return res;
    }

    private int getArea(int[] heights) {
        int n = heights.length;
        int[] newHeights = new int[n + 2];
        System.arraycopy(heights, 0, newHeights, 1, n);
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int h = newHeights[stack.pop()];
                int w = i - stack.peek() - 1;
                area = Math.max(area, w * h);
            }
            stack.push(i);
        }
        return area;
    }
}
