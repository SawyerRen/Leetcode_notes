package company.fbr3;

import java.util.*;

public class Q269 {
    public String alienOrder(String[] words) {
        Map<Character, Integer> preCount = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                preCount.put(c, 0);
            }
        }
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            if (s1.length() > s2.length() && s1.startsWith(s2)) return "";
            int minLen = Math.min(s1.length(), s2.length());
            for (int j = 0; j < minLen; j++) {
                char c1 = s1.charAt(j), c2 = s2.charAt(j);
                if (c1 != c2) {
                    map.putIfAbsent(c1, new HashSet<>());
                    if (!map.get(c1).contains(c2)) {
                        preCount.put(c2, preCount.get(c2) + 1);
                        map.get(c1).add(c2);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (Character c : preCount.keySet()) {
            if (preCount.get(c) == 0) {
                queue.add(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            builder.append(poll);
            if (map.containsKey(poll)) {
                for (Character c : map.get(poll)) {
                    preCount.put(c, preCount.get(c) - 1);
                    if (preCount.get(c) == 0) queue.add(c);
                }
            }
        }
        if (builder.length() != preCount.size()) return "";
        return builder.toString();
    }
}
