package topics.stack;

import java.util.Stack;

public class Q85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[] heights = new int[n + 2];
        int res = 0;
        for (char[] row : matrix) {
            for (int j = 0; j < n; j++) {
                if (row[j] == '0') heights[j + 1] = 0;
                else heights[j + 1]++;
            }
            res = Math.max(res, getArea(heights));
        }
        return res;
    }

    private int getArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxArea = 0;
        for (int i = 1; i < heights.length; i++) {
            while (heights[stack.peek()] > heights[i]) {
                int h = heights[stack.pop()];
                int w = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, w * h);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
