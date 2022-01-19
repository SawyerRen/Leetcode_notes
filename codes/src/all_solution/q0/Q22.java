package all_solution.q0;

import java.util.ArrayList;
import java.util.List;

public class Q22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), n, 0, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, int n, int left, int right) {
        if (left == n && right == n) {
            res.add(builder.toString());
            return;
        }
        if (left < n) {
            builder.append("(");
            helper(res, builder, n, left + 1, right);
            builder.setLength(builder.length() - 1);
        }
        if (right < left) {
            builder.append(")");
            helper(res, builder, n, left, right + 1);
            builder.setLength(builder.length() - 1);
        }
    }
}
