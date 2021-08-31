package topics.stack;

import java.util.Stack;

public class Q394 {
    public String decodeString(String s) {
        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                builder.append(c);
            } else if (Character.isDigit(c)) {
                count = count * 10 + c - '0';
            } else if (c == '[') {
                stringStack.push(builder);
                countStack.push(count);
                count = 0;
                builder = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = builder;
                builder = stringStack.pop();
                int k = countStack.pop();
                while (k-- > 0) builder.append(temp);
            }
        }
        return builder.toString();
    }
}
