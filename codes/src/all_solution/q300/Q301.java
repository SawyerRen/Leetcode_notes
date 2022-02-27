package all_solution.q300;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q301 {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        helper(res, s, new StringBuilder(), 0, left, right, 0);
        return new ArrayList<>(res);
    }

    private void helper(Set<String> res, String s, StringBuilder builder, int i, int left, int right, int open) {
        if (left < 0 || right < 0 || open < 0) return;
        if (i == s.length()) {
            if (left == 0 && right == 0 && open == 0) {
                res.add(builder.toString());
            }
            return;
        }
        char c = s.charAt(i);
        if (c == '(') {
            helper(res, s, builder, i + 1, left - 1, right, open);
            helper(res, s, builder.append(c), i + 1, left, right, open + 1);
        } else if (c == ')') {
            helper(res, s, builder, i + 1, left, right - 1, open);
            helper(res, s, builder.append(c), i + 1, left, right, open - 1);
        } else {
            helper(res, s, builder.append(c), i + 1, left, right, open);
        }
        builder.setLength(builder.length() - 1);
    }
}
