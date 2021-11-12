package company.fbr5.q500;

import java.util.Stack;

public class Q581 {
    public int findUnsortedSubarray(int[] nums) {
        int left = nums.length - 1, right = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                left = Math.min(stack.pop(), left);
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        if (right <= left) return 0;
        return right - left + 1;
    }
}
