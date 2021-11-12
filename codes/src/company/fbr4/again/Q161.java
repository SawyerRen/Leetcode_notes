package company.fbr4.again;

public class Q161 {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == t.length()) {
            boolean change = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (change) return false;
                    change = true;
                }
            }
            return change;
        } else {
            if (s.length() > t.length()) return isOneEditDistance(t, s);
            if (s.length() < t.length() - 1) return false;
            if (s.length() == 0) return true;
            int i = 0, j = 0;
            int change = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) != t.charAt(j)) {
                    if (change > 0) return false;
                    j++;
                    change++;
                } else {
                    i++;
                    j++;
                }
            }
            return true;
        }
    }
}
