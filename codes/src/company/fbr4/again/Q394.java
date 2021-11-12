package company.fbr4.again;

import java.util.Stack;

public class Q394 {
    public String decodeString(String s) {
        Stack<StringBuilder> builderStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                countStack.push(count);
                builderStack.push(builder);
                count = 0;
                builder = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = builder;
                builder = builderStack.pop();
                int k = countStack.pop();
                for (int i = 0; i < k; i++) {
                    builder.append(temp);
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
