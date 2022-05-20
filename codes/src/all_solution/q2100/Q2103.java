package all_solution.q2100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q2103 {
    public int countPoints(String rings) {
        HashMap<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            char rod = rings.charAt(i + 1);
            map.putIfAbsent(rod, new HashSet<>());
            map.get(rod).add(color);
        }
        int res = 0;
        for (Character rod : map.keySet()) {
            if (map.get(rod).size() == 3) res++;
        }
        return res;
    }
}
