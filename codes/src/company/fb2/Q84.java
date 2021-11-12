package company.fb2;

import java.util.Stack;

public class Q84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] h = new int[n + 2];
        System.arraycopy(heights, 0, h, 1, n);
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < h.length; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int height = h[stack.pop()];
                int w = i - stack.peek() - 1;
                res = Math.max(res, height * w);
            }
            stack.push(i);
        }
        return res;
    }
}
