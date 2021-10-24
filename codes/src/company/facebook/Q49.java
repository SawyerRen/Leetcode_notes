package company.facebook;

import java.util.*;

public class Q49 {
    // NK
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            String hash = Arrays.toString(count);
            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(str);
        }
        res.addAll(map.values());
        return res;
    }
}
