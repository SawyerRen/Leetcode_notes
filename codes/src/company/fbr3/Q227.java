package company.fbr3;

import java.util.Stack;

public class Q227 {
    public int calculate(String s) {
        int res = 0;
        int curNum = 0, preNum = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curNum = curNum * 10 + c - '0';
            }
            if (i == s.length() - 1 || (!Character.isDigit(c) && c != ' ')) {
                switch (sign) {
                    case '+' -> {
                        res += curNum;
                        preNum = curNum;
                    }
                    case '-' -> {
                        res -= curNum;
                        preNum = -curNum;
                    }
                    case '*' -> {
                        res = res - preNum + preNum * curNum;
                        preNum = preNum * curNum;
                    }
                    case '/' -> {
                        res = res - preNum + preNum / curNum;
                        preNum = preNum / curNum;
                    }
                }
                sign = c;
                curNum = 0;
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
            if (i == s.length() - 1 || !Character.isDigit(c) && c != ' ') {
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
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}
