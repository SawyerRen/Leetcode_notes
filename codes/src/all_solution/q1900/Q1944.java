package all_solution.q1900;

import java.util.Stack;

public class Q1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] >= heights[stack.peek()]) {
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
