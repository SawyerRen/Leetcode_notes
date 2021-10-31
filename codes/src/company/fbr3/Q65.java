package company.fbr3;

public class Q65 {
    public boolean isNumber(String s) {
        String s1 = s.toLowerCase();
        boolean numberBeforeE = false;
        boolean numberAfterE = false;
        boolean seenDot = false;
        boolean seenE = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s1.charAt(i);
            if (Character.isDigit(c)) {
                if (seenE) numberAfterE = true;
                else numberBeforeE = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s1.charAt(i - 1) != 'e') return false;
            } else if (c == '.') {
                if (seenDot || seenE) return false;
                seenDot = true;
            } else if (c == 'e') {
                if (seenE) return false;
                seenE = true;
            } else {
                return false;
            }
        }
        if (seenE) return numberAfterE && numberBeforeE;
        return numberBeforeE;
    }
}
