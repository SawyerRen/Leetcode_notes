package all_solution.q300;

public class Q392 {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (i == s.length()) return true;
            if (t.charAt(j) == s.charAt(i)) i++;
        }
        return i == s.length();
    }
}
