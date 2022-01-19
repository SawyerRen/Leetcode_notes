package all_solution.q0;

import java.util.*;

public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] hash = new int[26];
            for (char c : str.toCharArray()) {
                hash[c - 'a']++;
            }
            String pattern = Arrays.toString(hash);
            map.putIfAbsent(pattern, new ArrayList<>());
            map.get(pattern).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
