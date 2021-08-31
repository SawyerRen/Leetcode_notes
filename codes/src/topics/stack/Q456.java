package topics.stack;

import java.util.Stack;

public class Q456 {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int secondMax = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < secondMax) return true;
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                secondMax = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}
