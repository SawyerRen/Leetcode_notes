package all_solution.q200;

import java.util.Stack;

public class Q255 {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int val : preorder) {
            if (val < min) return false;
            while (!stack.isEmpty() && val > stack.peek()) {
                min = stack.pop();
            }
            stack.push(val);
        }
        return true;
    }
}
