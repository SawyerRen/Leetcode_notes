package company.facebook;

public class Q647 {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += helper(s, i, i);
            res += helper(s, i, i + 1);
        }
        return res;
    }

    private int helper(String s, int i, int j) {
        int res = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) break;
            res++;
            i--;
            j++;
        }
        return res;
    }
}
