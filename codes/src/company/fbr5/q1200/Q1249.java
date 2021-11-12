package company.fbr5.q1200;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') right++;
        }
        int left = 0;
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (right > 0) {
                    builder.append(c);
                    right--;
                }
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    builder.append(c);
                    left--;
                } else {
                    right--;
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
