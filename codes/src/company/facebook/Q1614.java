package company.facebook;

public class Q1614 {
    public int maxDepth(String s) {
        int open = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                res = Math.max(res, open);
            } else if (c == ')') {
                open--;
            }
        }
        return res;
    }
}
