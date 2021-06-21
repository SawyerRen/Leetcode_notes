package topics.hashtable;

import java.util.*;

public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] hash = new int[26];
            for (char c : str.toCharArray()) {
                hash[c - 'a']++;
            }
            String hashStr = Arrays.toString(hash);
            map.putIfAbsent(hashStr, new ArrayList<>());
            map.get(hashStr).add(str);
        }
        List<List<String>> res = new ArrayList<>(map.size());
        res.addAll(map.values());
        return res;
    }
}
