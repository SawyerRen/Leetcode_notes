package all_solution.q700;

import java.util.TreeMap;

public class Q796 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        if (s.length() == 0) return true;
        for (int i = 0; i < s.length(); i++) {
            if (valid(s, goal, i)) return true;
        }
        return false;
    }

    private boolean valid(String s1, String s2, int rotate) {
        boolean valid = true;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt((i + rotate) % s2.length())) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}
