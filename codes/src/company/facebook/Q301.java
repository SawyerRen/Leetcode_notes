package company.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q301 {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        Set<String> res = new HashSet<>();
        helper(res, s, new StringBuilder(), left, right, 0, 0);
        return new ArrayList<>(res);
    }

    private void helper(Set<String> res, String s, StringBuilder builder, int left, int right, int open, int i) {
        if (left < 0 || right < 0 || open < 0) return;
        if (i == s.length()) {
            if (left == 0 && right == 0 && open == 0) {
                res.add(builder.toString());
            }
            return;
        }
        char c = s.charAt(i);
        int length = builder.length();
        if (c == '(') {
            helper(res, s, builder, left - 1, right, open, i + 1);
            helper(res, s, builder.append(c), left, right, open + 1, i + 1);
        } else if (c == ')') {
            helper(res, s, builder, left, right - 1, open, i + 1);
            helper(res, s, builder.append(c), left, right, open - 1, i + 1);
        } else {
            helper(res, s, builder.append(c), left, right, open, i + 1);
        }
        builder.setLength(length);
    }
}
