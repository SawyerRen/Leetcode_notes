package company.fbr5.q1400;

public class Q1614 {
    public int maxDepth(String s) {
        int res = 0, depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '('){
                depth++;
                res = Math.max(res, depth);
            }
            else if (c == ')') depth--;
        }
        return res;
    }
}
