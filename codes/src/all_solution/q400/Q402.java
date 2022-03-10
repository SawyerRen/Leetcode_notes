package all_solution.q400;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Q402 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > num.charAt(i)) {
                stack.removeLast();
                k--;
            }
            stack.addLast(num.charAt(i));
        }
        while (k-- > 0) {
            stack.removeLast();
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.removeLast());
        }
        while (builder.length() > 0 && builder.charAt(builder.length() - 1) == '0') {
            builder.setLength(builder.length() - 1);
        }
        if (builder.length() == 0) return "0";
        return builder.reverse().toString();
    }
}
