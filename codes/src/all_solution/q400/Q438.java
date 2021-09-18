package all_solution.q400;

import java.util.ArrayList;
import java.util.List;

public class Q438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) return res;
        int[] hash = new int[26];
        for (char c : p.toCharArray()) {
            hash[c - 'a']++;
        }
        for (int i = 0; i < p.length(); i++) {
            hash[s.charAt(i) - 'a']--;
        }
        if (allZero(hash)) res.add(0);

        int i = 0, j = p.length();
        while (j < s.length()) {
            hash[s.charAt(i++) - 'a']--;
            hash[s.charAt(j++) - 'a']++;
            if (allZero(hash)) res.add(i);
        }
        return res;
    }

    private boolean allZero(int[] hash) {
        for (int i : hash) {
            if (i != 0) return false;
        }
        return true;
    }
}
