package all_solution.q1400;

public class Q1446 {
    public int maxPower(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int len = 1;
            while (i + 1 < s.length() && s.charAt(i + 1) == c) {
                i++;
                len++;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
