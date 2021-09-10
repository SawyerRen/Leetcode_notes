package all_solution.q300;

public class Q205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] hashS = new int[128];
        int[] hashT = new int[128];
        for (int i = 0; i < s.length(); i++) {
            if (hashS[s.charAt(i)] != hashT[t.charAt(i)]) return false;
            hashS[s.charAt(i)] = i + 1;
            hashT[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
