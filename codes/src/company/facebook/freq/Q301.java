package company.facebook.freq;

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
        Set<String> list = new HashSet<>();
        helper(list, new StringBuilder(), 0, left, right, 0, s);
        return new ArrayList<>(list);
    }

    private void helper(Set<String> list, StringBuilder builder, int i, int left, int right, int open, String s) {
        if (left < 0 || right < 0 || open < 0) return;
        if (i == s.length()) {
            if (left == 0 && right == 0 && open == 0) {
                list.add(builder.toString());
            }
            return;
        }
        char c = s.charAt(i);
        if (c == '(') {
            helper(list, builder, i + 1, left - 1, right, open, s);
            helper(list, builder.append(c), i + 1, left, right, open + 1, s);
        } else if (c == ')') {
            helper(list, builder, i + 1, left, right - 1, open, s);
            helper(list, builder.append(c), i + 1, left, right, open - 1, s);
        } else {
            helper(list, builder.append(c), i + 1, left, right, open, s);
        }
        builder.setLength(builder.length() - 1);
    }
}
