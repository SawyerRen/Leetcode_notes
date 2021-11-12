package company.fbr4.again;

import java.util.Stack;

public class Q1944 {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                res[stack.pop()]++;
            }
            if (!stack.isEmpty()) {
                res[stack.peek()]++;
            }
            stack.push(i);
        }
        return res;
    }
}
