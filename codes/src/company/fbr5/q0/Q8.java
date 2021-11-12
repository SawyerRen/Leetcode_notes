package company.fbr5.q0;

public class Q8 {
    public int myAtoi(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        if (i == s.length()) return 0;
        boolean negative = false;
        if (s.charAt(i) == '-') {
            negative = true;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        long num = 0;
        while (i < s.length()) {
            if (!Character.isDigit(s.charAt(i))) break;
            num = num * 10 + s.charAt(i) - '0';
            if (num > Integer.MAX_VALUE) {
                if (negative) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            i++;
        }
        if (negative) return -(int) num;
        return (int) num;
    }
}
