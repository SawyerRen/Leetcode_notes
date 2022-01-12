package company.fbr5.q700;

import java.util.Stack;

public class Q735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean push = true;
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() > -asteroid) {
                    push = false;
                    break;
                } else if (stack.peek() == -asteroid) {
                    push = false;
                    stack.pop();
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
