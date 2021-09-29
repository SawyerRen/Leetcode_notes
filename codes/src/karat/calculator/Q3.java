package karat.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Q3 {
    public static String basicCalculator2(String expression, Map<Character, Integer> map) {
        if (expression.length() == 0) return "";
        int res = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    num = num * 10 + expression.charAt(i + 1) - '0';
                    i++;
                }
                res += sign * num;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res = res * stack.pop() + stack.pop();
            } else if (map.containsKey(c)) {
                res += sign * map.get(c);
            } else {
                if (sign == -1) {
                    list.add("-" + c);
                } else {
                    list.add("+" + c);
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(res);
        for (String s : list) {
            builder.append(s);
        }
        return builder.toString();
    }
}
