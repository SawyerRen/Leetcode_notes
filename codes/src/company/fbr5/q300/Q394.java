package company.fbr5.q300;

import java.util.Stack;

public class Q394 {
    public String decodeString(String s) {
        StringBuilder builder = new StringBuilder();
        Stack<StringBuilder> builderStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                builderStack.push(builder);
                countStack.push(count);
                builder = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                StringBuilder temp = builder;
                builder = builderStack.pop();
                for (int j = countStack.pop(); j > 0; j--) {
                    builder.append(temp);
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
