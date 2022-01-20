package all_solution.q0;

public class Q65 {
    public boolean isNumber(String s) {
        boolean numBeforeE = false, numAfterE = false, seenE = false, seenDot = false;
        String s1 = s.toLowerCase();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (Character.isDigit(c)) {
                if (seenE) numAfterE = true;
                else numBeforeE = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s1.charAt(i - 1) != 'e') return false;
            } else if (c == 'e') {
                if (seenE) return false;
                seenE = true;
            } else if (c == '.') {
                if (seenDot || seenE) return false;
                seenDot = true;
            } else return false;
        }
        return seenE ? numAfterE && numBeforeE : numBeforeE;
    }
}
