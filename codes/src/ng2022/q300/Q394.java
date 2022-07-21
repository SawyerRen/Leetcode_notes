package ng2022.q300;

import java.util.Stack;

public class Q394 {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> builderStack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                countStack.push(num);
            } else {
                if (s.charAt(i) == '[') {
                    builderStack.push(builder);
                    builder = new StringBuilder();
                } else if (s.charAt(i) == ']') {
                    int count = countStack.pop();
                    StringBuilder pre = builderStack.pop();
                    pre.append(String.valueOf(builder).repeat(Math.max(0, count)));
                    builder = pre;
                } else {
                    builder.append(s.charAt(i));
                }
            }
        }
        return builder.toString();
    }
}
