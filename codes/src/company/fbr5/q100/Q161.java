package company.fbr5.q100;

public class Q161 {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() == t.length()) {
            int change = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (change > 0) return false;
                    change++;
                }
            }
            return change == 1;
        } else {
            if (s.length() > t.length()) return isOneEditDistance(t, s);
            if (s.length() < t.length() - 1) return false;
            if (s.length() == 0) return true;
            int i = 0, j = 0, change = 0;
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) != t.charAt(j)) {
                    if (change > 0) return false;
                    change++;
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
            return true;
        }
    }
}
