package all_solution.q100;

public class Q161 {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        int count = 0;
        int i = 0;
        // 保证s长度大于等于t
        if (s.length() < t.length()) return isOneEditDistance(t, s);
        if (s.length() == t.length()) {
            while (i < s.length()) {
                if (s.charAt(i) != t.charAt(i)) count++;
                if (count > 1) return false;
                i++;
            }
            return count == 1;
        } else {
            if (t.length() == 0) return true;
            while (i < t.length()) {
                if (s.charAt(i) != t.charAt(i)) return s.substring(i + 1).equals(t.substring(i));
                i++;
            }
        }
        return true;
    }
}
