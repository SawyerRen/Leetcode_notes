package ng2022.q0;

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
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                res = res * 10 + c - '0';
                if (res > Integer.MAX_VALUE) {
                    if (negative) return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
            } else {
                break;
            }
            index++;
        }
        if (negative) return (int) -res;
        return (int) res;
    }
}
