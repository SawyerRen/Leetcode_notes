package company.fbr4.q200;

import java.util.Stack;

public class Q227 {
    public int calculate(String s) {
        int cur = 0, pre = 0, res = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            }
            if (i == s.length() - 1 || (!Character.isDigit(c) && c != ' ')) {
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
                        res = res - pre + cur * pre;
                        pre = cur * pre;
                    }
                    case '/' -> {
                        res = res - pre + pre / cur;
                        pre = pre / cur;
                    }
                }
                cur = 0;
                sign = c;
            }
        }
        return res;
    }

    public int calculate1(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (i == s.length() - 1 || (!Character.isDigit(c) && c != ' ')) {
                switch (sign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                num = 0;
                sign = c;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
