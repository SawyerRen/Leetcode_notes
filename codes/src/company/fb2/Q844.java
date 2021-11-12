package company.fb2;

public class Q844 {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int countS = 0, countT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0 && (s.charAt(i) == '#' || countS > 0)) {
                if (s.charAt(i) == '#') countS++;
                else countS--;
                i--;
            }
            while (j >= 0 && (t.charAt(j) == '#' || countT > 0)) {
                if (t.charAt(j) == '#') countT++;
                else countT--;
                j--;
            }
            char c1 = i >= 0 ? s.charAt(i) : '/';
            char c2 = j >= 0 ? t.charAt(j) : '/';
            if (c1 != c2) return false;
            i--;
            j--;
        }
        return true;
    }
}
