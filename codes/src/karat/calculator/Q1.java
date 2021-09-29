package karat.calculator;

public class Q1 {
    public static int basicCalculator(String expression) {
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
                res += sign * num;
            } else if (c == '+') sign = 1;
            else if (c == '-') sign = -1;
        }
        return res;
    }
}
