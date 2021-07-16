package topics.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q301 {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        // 获得多出的左括号和右括号的数量
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') {
                if (left > 0) left--;
                else right++;
            }
        }
        helper(res, new StringBuilder(), s, 0, left, right, 0);
        return new ArrayList<>(res);
    }

    private void helper(Set<String> res, StringBuilder builder, String s, int index, int left, int right, int open) {
        if (left < 0 || right < 0 || open < 0) return;
        if (index == s.length()) {
            if (left == 0 && right == 0 && open == 0) res.add(builder.toString());
            return;
        }
        int len = builder.length();
        char c = s.charAt(index);
        if (c == '(') {
            helper(res, builder.append(c), s, index + 1, left, right, open + 1);
            builder.setLength(len);
            helper(res, builder, s, index + 1, left - 1, right, open);
        } else if (c == ')') {
            helper(res, builder.append(c), s, index + 1, left, right, open - 1);
            builder.setLength(len);
            helper(res, builder, s, index + 1, left, right - 1, open);
        } else {
            helper(res, builder.append(c), s, index + 1, left, right, open);
            builder.setLength(len);
        }
    }
}
