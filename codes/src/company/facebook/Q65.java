package company.facebook;

public class Q65 {
    public boolean isNumber(String s) {
        s = s.trim().toLowerCase();
        boolean numberBeforeE = false;
        boolean numberAfterE = false;
        boolean dot = false;
        boolean e = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                if (e) numberAfterE = true;
                else numberBeforeE = true;
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') return false;
            } else if (c == '.') {
                if (e || dot) return false;
                dot = true;
            } else if (c == 'e') {
                if (e) return false;
                e = true;
            } else {
                return false;
            }
        }
        if (e) return numberAfterE && numberBeforeE;
        return numberBeforeE;
    }
}
