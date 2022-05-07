package all_solution.q1600;

public class Q1614 {
    public int maxDepth(String s) {
        int depth = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                res = Math.max(res, depth);
            } else if (c == ')') {
                depth--;
            }
        }
        return res;
    }
}
