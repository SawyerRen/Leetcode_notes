package all_solution.q2100;

import java.util.Stack;

public class Q2104 {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n + 1; i++) {
            while (!stack.isEmpty() && (i == n || nums[i] > nums[stack.peek()])) {
                Integer pop = stack.pop();
                int left = pop - (stack.isEmpty() ? -1 : stack.peek());
                int right = i - pop;
                res += (long) nums[pop] * left * right;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < n + 1; i++) {
            while (!stack.isEmpty() && (i == n || nums[i] < nums[stack.peek()])) {
                Integer pop = stack.pop();
                int left = pop - (stack.isEmpty() ? -1 : stack.peek());
                int right = i - pop;
                res -= (long) nums[pop] * left * right;
            }
            stack.push(i);
        }
        return res;
    }
}
