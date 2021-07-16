package topics.hashtable;

public class Q205 {
    public boolean isIsomorphic(String s, String t) {
        int[] hashS = new int[128];
        int[] hashT = new int[128];
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            int indexS = s.charAt(i);
            int indexT = t.charAt(i);
            if (hashS[indexS] != hashT[indexT]) return false;
            hashS[indexS] = i + 1;
            hashT[indexT] = i + 1;
        }
        return true;
    }
}
