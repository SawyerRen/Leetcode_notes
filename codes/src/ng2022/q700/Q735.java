package ng2022.q700;

import java.util.LinkedList;
import java.util.Stack;

public class Q735 {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int asteroid : asteroids) {
            boolean push = true;
            if (asteroid < 0) {
                while (!stack.isEmpty() && stack.peekLast() > 0) {
                    if (stack.peekLast() > -asteroid) {
                        push = false;
                        break;
                    } else if (stack.peekLast() == -asteroid) {
                        stack.removeLast();
                        push = false;
                        break;
                    } else {
                        stack.removeLast();
                    }
                }
            }
            if (push) stack.addLast(asteroid);
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeFirst();
        }
        return res;
    }
}
