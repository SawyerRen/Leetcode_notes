package all_solution.q300;

import java.util.Stack;

public class Q394 {
    public String decodeString(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                stack.push(builder);
                countStack.push(count);
                builder = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                Integer pop = countStack.pop();
                StringBuilder temp = builder;
                builder = stack.pop();
                builder.append(String.valueOf(temp).repeat(Math.max(0, pop)));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
