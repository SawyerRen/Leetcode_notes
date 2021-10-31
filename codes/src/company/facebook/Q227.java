package company.facebook;

import java.util.Stack;

public class Q227 {
    public int calculate(String s) {
        int res = 0;
        int cur = 0, pre = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                cur = cur * 10 + s.charAt(i) - '0';
            }
            if (i == s.length() - 1 || (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ')) {
                switch (sign) {
                    case '+' -> {
                        res += cur;
                        pre = cur;
                    }
                    case '-' -> {
                        res -= cur;
                        pre = -cur;
                    }
                    case '*' -> {
                        res = res - pre + pre * cur;
                        pre = pre * cur;
                    }
                    case '/' -> {
                        res = res - pre + pre / cur;
                        pre = pre / cur;
                    }
                }
                sign = s.charAt(i);
                cur = 0;
            }
        }
        return res;
    }

    public int calculate1(String s) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (i == s.length() - 1 || (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ')) {
                switch (sign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
