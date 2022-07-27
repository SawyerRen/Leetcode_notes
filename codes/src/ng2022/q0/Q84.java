package ng2022.q0;

import java.util.Stack;

public class Q84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.size() > 1 && heights[i] < heights[stack.peek()]) {
                Integer index = stack.pop();
                int h = heights[index];
                int w = i - stack.peek() - 1;
                res = Math.max(res, h * w);
            }
            stack.push(i);
        }
        while (stack.size() > 1) {
            int h = heights[stack.pop()];
            int w = heights.length - stack.peek() - 1;
            res = Math.max(res, h * w);
        }
        return res;
    }
}
