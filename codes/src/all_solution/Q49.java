package all_solution;

import java.util.*;

public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] hash = new int[26];
            for (char c : str.toCharArray()) {
                hash[c - 'a']++;
            }
            String s = Arrays.toString(hash);
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
