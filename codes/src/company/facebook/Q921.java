package company.facebook;

import java.util.Stack;

public class Q921 {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            if (c == ')') {
                if (open > 0) open--;
                else close++;
            }
        }
        return open + close;
    }

    public int minAddToMakeValid1(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || c == '(') stack.push(c);
            else if (c == ')') {
                if (stack.peek() == '(') stack.pop();
                else stack.push(c);
            }
        }
        return stack.size();
    }
}
