package topics.hashtable;

import java.util.Arrays;

public class Q242 {
    public boolean isAnagram(String s, String t) {
        int[] hashS = new int[26];
        int[] hashT = new int[26];
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            hashS[s.charAt(i) - 'a']++;
            hashT[t.charAt(i) - 'a']++;
        }
        return Arrays.toString(hashS).equals(Arrays.toString(hashT));
    }
}
