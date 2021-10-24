package company.facebook;

public class Q65 {
    public boolean isNumber(String s) {
        s = s.toLowerCase().trim();
        boolean numberBeforeE = false;
        boolean numberAfterE = false;
        boolean seenE = false;
        boolean seenDot = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (seenE) numberAfterE = true;
                else numberBeforeE = true;
            } else if (c == '-' || c == '+') {
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
