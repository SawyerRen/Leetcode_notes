package all_solution.q100;

public class Q161 {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        if (s.length() < t.length()) return isOneEditDistance(t, s);
        if (s.length() == t.length()) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) count++;
            }
            if (count != 1) return false;
        } else {
            if (t.length() == 0) return true;
            int i = 0;
            while (i < t.length()) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i + 1).equals(t.substring(i));
                }
                i++;
            }
            return true;
        }
        return true;
    }
}
