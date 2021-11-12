package company.fb2;

public class Q1614 {
    public int maxDepth(String s) {
        int res = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                res++;
                max = Math.max(max, res);
            } else if (s.charAt(i) == ')') {
                res--;
            }
        }
        return max;
    }
}
