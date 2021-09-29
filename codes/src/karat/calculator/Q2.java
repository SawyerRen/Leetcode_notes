package karat.calculator;

import java.util.Stack;

public class Q2 {
    public static int basicCalculator2(String expression) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    num = num * 10 + expression.charAt(i + 1) - '0';
                    i++;
                }
                res += num * sign;
            } else if (c == '-') sign = -1;
            else if (c == '+') sign = 1;
            else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }
}
