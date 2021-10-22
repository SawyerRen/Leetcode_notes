package company.facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q301 {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        Set<String> set = new HashSet<>();
        helper(s, set, new StringBuilder(), 0, left, right, 0);
        return new ArrayList<>(set);
    }

    private void helper(String s, Set<String> set, StringBuilder builder, int i, int left, int right, int open) {
        if (left < 0 || right < 0 || open < 0) return;
        if (i == s.length()) {
            if (left == 0 && right == 0 && open == 0) {
                set.add(builder.toString());
            }
            return;
        }
        char c = s.charAt(i);
        int length = builder.length();
        if (c == '(') {
            helper(s, set, builder, i + 1, left - 1, right, open);
            helper(s, set, builder.append(c), i + 1, left, right, open + 1);
        } else if (c == ')') {
            helper(s, set, builder, i + 1, left, right - 1, open);
            helper(s, set, builder.append(c), i + 1, left, right, open - 1);
        } else {
            helper(s, set, builder.append(c), i + 1, left, right, open);
        }
        builder.setLength(length);
    }
}
