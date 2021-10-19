package company.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, int open, int close, int n) {
        if (open == n && close == n) {
            res.add(builder.toString());
            return;
        }
        int length = builder.length();
        if (open < n) {
            builder.append("(");
            helper(res, builder, open + 1, close, n);
            builder.setLength(length);
        }
        if (close < open) {
            builder.append(")");
            helper(res, builder, open, close + 1, n);
            builder.setLength(length);
        }
    }
}
