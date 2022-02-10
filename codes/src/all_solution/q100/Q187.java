package all_solution.q100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> once = new HashSet<>();
        Set<String> twice = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String sub = s.substring(i, i + 10);
            if (!once.contains(sub)) {
                once.add(sub);
            } else {
                twice.add(sub);
            }
        }
        return new ArrayList<>(twice);
    }
}
