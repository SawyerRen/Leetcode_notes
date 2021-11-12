package company.fb2;

import java.util.HashSet;
import java.util.Set;

public class Q1554 {
    public boolean differByOne(String[] dict) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < dict[0].length(); i++) {
            set.clear();
            for (String s : dict) {
                String s1 = s.substring(0, i) + s.substring(i + 1);
                if (set.contains(s1)) return true;
                set.add(s1);
            }
        }
        return false;
    }
}
