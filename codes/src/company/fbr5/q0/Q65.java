package company.fbr5.q0;

public class Q65 {
    public boolean isNumber(String s) {
        String s1 = s.toLowerCase();
        boolean numberBeforeE = false, numberAfterE = false, seenE = false, seenDot = false;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (Character.isDigit(c)) {
                if (seenE) numberAfterE = true;
                else numberBeforeE = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e') return false;
            } else if (c == 'e') {
                if (seenE) return false;
                seenE = true;
            } else if (c == '.') {
                if (seenDot || seenE) return false;
                seenDot = true;
            } else {
                return false;
            }
        }
        if (seenE) return numberAfterE && numberBeforeE;
        return numberBeforeE;
    }
}
