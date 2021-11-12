package company.fbr4.q300;

import java.util.Stack;

public class Q394 {
    public String decodeString(String s) {
        StringBuilder builder = new StringBuilder();
        Stack<StringBuilder> strStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                strStack.push(builder);
                countStack.push(count);
                builder = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                StringBuilder temp = builder;
                builder = strStack.pop();
                for (int i = countStack.pop(); i > 0; i--) {
                    builder.append(temp);
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
