package topics.math;

public class Q8 {
    public int myAtoi(String s) {
        int i = 0;
        long res = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) return 0;
        boolean negative = false;
        if (s.charAt(i) == '-') {
            i++;
            negative = true;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        while (i < s.length()) {
            int c = s.charAt(i);
            if (c > '9' || c < '0') break;
            res = res * 10 + (c - '0');
            if (res > Integer.MAX_VALUE) {
                if (negative) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            i++;
        }
        if (negative) return -(int) res;
        return (int) res;
    }
}
