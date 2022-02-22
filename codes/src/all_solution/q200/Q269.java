package all_solution.q200;

import java.util.*;

public class Q269 {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> preCount = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                preCount.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i], word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) return "";
            for (int j = 0; j < word1.length(); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    char c1 = word1.charAt(j);
                    char c2 = word2.charAt(j);
                    map.putIfAbsent(c1, new HashSet<>());
                    if (!map.get(c1).contains(c2)) {
                        map.get(c1).add(c2);
                        preCount.put(c2, preCount.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (Character c1 : preCount.keySet()) {
            if (preCount.get(c1) == 0) {
                queue.add(c1);
            }
        }
        while (!queue.isEmpty()) {
            Character c1 = queue.poll();
            builder.append(c1);
            if (map.containsKey(c1)) {
                for (Character c2 : map.get(c1)) {
                    preCount.put(c2, preCount.get(c2) - 1);
                    if (preCount.get(c2) == 0) {
                        queue.add(c2);
                    }
                }
            }
        }
        if (builder.length() != preCount.size()) return "";
        return builder.toString();
    }
}
