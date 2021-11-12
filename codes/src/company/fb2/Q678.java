package company.fb2;

public class Q678 {
    public boolean checkValidString(String s) {
        int openMax = 0, openMin = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openMax++;
                openMin++;
            } else if (c == ')') {
                openMax--;
                openMin--;
            } else if (c == '*') {
                openMax++;
                openMin--;
            }
            if (openMax < 0) return false;
            if (openMin < 0) openMin = 0;
        }
        return openMin == 0;
    }
}
