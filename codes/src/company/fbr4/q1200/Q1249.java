package company.fbr4.q1200;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        int open = 0, close = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') close++;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (close > 0) {
                    builder.append(c);
                    close--;
                }
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    builder.append(c);
                    open--;
                } else {
                    close--;
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
