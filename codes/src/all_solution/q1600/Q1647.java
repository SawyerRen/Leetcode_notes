package all_solution.q1600;

import java.util.HashSet;
import java.util.Set;

public class Q1647 {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int f : freq) {
            while (f > 0) {
                if (!set.contains(f)) {
                    set.add(f);
                    break;
                }
                f--;
                res++;
            }
        }
        return res;
    }
}
