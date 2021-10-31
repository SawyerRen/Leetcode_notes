package company.fbr3;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubstringSizeK {
    public static Set<String> uniqueSubstringSizeK(String s, int k) {
        Set<Character> set = new HashSet<>();
        Set<String> res = new HashSet<>();
        int i = 0, j = 0;
        while (j < s.length()) {
            char rc = s.charAt(j);
            while (set.contains(rc)) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(rc);
            if (set.size() == k) {
                res.add(s.substring(i, j + 1));
            }
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abacab";
        int k = 3;
        Set<String> set = uniqueSubstringSizeK(s, k);
        for (String s1 : set) {
            System.out.println(s1);
        }
    }
}
