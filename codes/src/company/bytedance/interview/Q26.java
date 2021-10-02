package company.bytedance.interview;

import java.util.Stack;

/*
735. Asteroid Collision
 */
public class Q26 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0 && Math.abs(asteroid) > Math.abs(stack.peek())) {
                stack.pop();
            }
            if (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0 && Math.abs(asteroid) == Math.abs(stack.peek())) {
                stack.pop();
                continue;
            }
            if (stack.isEmpty() || !(stack.peek() > 0 && asteroid < 0)) {
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
