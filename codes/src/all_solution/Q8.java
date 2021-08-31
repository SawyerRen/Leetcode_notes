package all_solution;

public class Q8 {
    public int myAtoi(String s) {
        long res = 0;
        int index = 0;
        while (index < s.length() && s.charAt(index) == ' ') index++;
        if (index == s.length()) return 0;
        boolean negative = false;
        if (s.charAt(index) == '-') {
            negative = true;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c < '0' || c > '9') break;
            res = res * 10 + c - '0';
            if (res > Integer.MAX_VALUE) {
                if (negative) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            index++;
        }
        if (negative) return -(int) res;
        return (int) res;
    }
}
