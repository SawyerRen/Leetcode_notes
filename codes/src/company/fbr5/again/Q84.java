package company.fbr5.again;

import java.util.Stack;

public class Q84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] temp = new int[n + 2];
        System.arraycopy(heights, 0, temp, 1, n);
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[i] < temp[stack.peek()]) {
                int h = temp[stack.pop()];
                int w = i - stack.peek() - 1;
                res = Math.max(res, w * h);
            }
            stack.push(i);
        }
        return res;
    }
}
