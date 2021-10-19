package company.facebook;

public class Q844 {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int countS = 0, countT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (countS > 0 || s.charAt(i) == '#')) {
                if (s.charAt(i) == '#') countS++;
                else countS--;
                i--;
            }
            char sc = i >= 0 ? s.charAt(i) : '@';
            while (j >= 0 && (countT > 0 || t.charAt(j) == '#')) {
                if (t.charAt(j) == '#') countT++;
                else countT--;
                j--;
            }
            char tc = j >= 0 ? t.charAt(j) : '@';
            if (sc != tc) return false;
            i--;
            j--;
        }
        return true;
    }
}
