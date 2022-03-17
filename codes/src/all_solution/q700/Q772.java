package all_solution.q700;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q772 {
    public int calculate(String s) {
        if (s.length() == 0) return 0;
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.add(c);
        }
        queue.add('+');
        return helper(queue);
    }

    private int helper(Queue<Character> queue) {
        if (queue.isEmpty()) return 0;
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '(') {
                num = helper(queue);
            } else {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
                if (c == ')') break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}
