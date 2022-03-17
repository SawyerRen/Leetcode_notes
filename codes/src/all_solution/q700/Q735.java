package all_solution.q700;

import java.util.Stack;

public class Q735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean push = true;
            while (asteroid < 0 && !stack.isEmpty()) {
                if (stack.peek() < 0) break;
                if (stack.peek() > 0) {
                    if (-asteroid > stack.peek()) {
                        stack.pop();
                    } else if (-asteroid == stack.peek()) {
                        stack.pop();
                        push = false;
                        break;
                    } else {
                        push = false;
                        break;
                    }
                }
            }
            if (push) stack.push(asteroid);
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
