package company.facebook;

import java.util.Stack;

public class Q227 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        char sign = '+';
        int num = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                num = c - '0';
                while (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
                    num = num * 10 + chars[i + 1] - '0';
                    i++;
                }
            }
            if (!Character.isDigit(c) && chars[i] != ' ' || i == chars.length - 1) {
                switch (sign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
