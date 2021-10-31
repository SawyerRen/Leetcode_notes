package company.fbr3;

public class Q8 {
    public int myAtoi(String s) {
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
        long res = 0;
        while (index < s.length()) {
            if (!Character.isDigit(s.charAt(index))) break;
            res = res * 10 + s.charAt(index) - '0';
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
