package company.facebook;

public class Q8 {
    public int myAtoi(String s) {
        long res = 0;
        int index = 0;
        char[] chars = s.toCharArray();
        while (index < chars.length && chars[index] == ' ') index++;
        if (index == s.length()) return 0;
        boolean negative = false;
        if (chars[index] == '-') {
            negative = true;
            index++;
        } else if (chars[index] == '+') {
            index++;
        }
        for (int i = index; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') break;
            res = res * 10 + chars[i] - '0';
            if (res > Integer.MAX_VALUE) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return negative ? -(int) res : (int) res;
    }
}
