package all_solution.q1500;

import java.util.HashSet;
import java.util.Set;

public class Q1554 {
    public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            for (int i = 0; i < s.length(); i++) {
                char[] chars = s.toCharArray();
                chars[i] = '*';
                String s1 = new String(chars);
                if (set.contains(s1)) return true;
                set.add(s1);
            }
        }
        return false;
    }
}
