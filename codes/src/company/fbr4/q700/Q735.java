package company.fbr4.q700;

import java.util.Stack;

public class Q735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean push = true;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if (stack.peek() >= -asteroid) {
                    push = false;
                    if (stack.peek() == -asteroid) stack.pop();
                    break;
                } else {
                    stack.pop();
                }
            }
            if (push) {
                stack.push(asteroid);
            }
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
