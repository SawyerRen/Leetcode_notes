package ng2022.q200;

import java.util.Stack;

public class Q224 {
    public int calculate(String s) {
        int res = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += num * sign;
            }
            if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop();
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            }
        }
        return res;
    }
}
