package company.fbr3;

import java.util.Stack;

public class Q581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = n - 1, right = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                Integer pop = stack.pop();
                left = Math.min(left, pop);
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                Integer pop = stack.pop();
                right = Math.max(pop, right);
            }
            stack.push(i);
        }
        if (left >= right) return 0;
        return right - left + 1;
    }
}
