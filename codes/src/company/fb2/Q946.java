package company.fb2;

import java.util.Stack;

public class Q946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int val : pushed) {
            stack.push(val);
            while (!stack.isEmpty() && popped[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }
        return index == popped.length;
    }
}
