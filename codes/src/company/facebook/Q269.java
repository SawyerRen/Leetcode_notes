package company.facebook;

import java.util.*;

public class Q269 {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        Map<Character, Integer> preCount = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                preCount.put(c, 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            if (s1.length() > s2.length() && s1.startsWith(s2)) return "";
            int minLen = Math.min(s1.length(), s2.length());
            for (int j = 0; j < minLen; j++) {
                if (s1.charAt(j) == s2.charAt(j)) continue;
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                Set<Character> set = graph.getOrDefault(c1, new HashSet<>());
                if (!set.contains(c2)) {
                    set.add(c2);
                    graph.put(c1, set);
                    preCount.put(c2, preCount.get(c2) + 1);
                }
                break;
            }
        }
        Queue<Character> queue = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        for (Character c : preCount.keySet()) {
            if (preCount.get(c) == 0) {
                queue.add(c);
            }
        }
        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            builder.append(poll);
            if (graph.containsKey(poll)) {
                for (Character c : graph.get(poll)) {
                    preCount.put(c, preCount.get(c) - 1);
                    if (preCount.get(c) == 0) {
                        queue.add(c);
                    }
                }
            }
        }
        if (builder.length() == preCount.size()) return builder.toString();
        return "";
    }
}
