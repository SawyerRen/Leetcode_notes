package topics.graph;

import java.util.*;

public class Q269 {
    public String alienOrder(String[] words) {
        // 构建图
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
                // 字符相同，跳过
                if (words[i].charAt(j) == words[i + 1].charAt(j)) continue;
                // 保存依赖关系
                map.putIfAbsent(words[i].charAt(j), new HashSet<>());
                map.get(words[i].charAt(j)).add(words[i + 1].charAt(j));
            }
        }
        // 拓扑排序
        int[] degrees = new int[26];
        // 没有出现的字符为-1
        Arrays.fill(degrees, -1);
        // 出现的字符置为0
        for (String word : words) {
            for (char c : word.toCharArray()) {
                degrees[c - 'a'] = 0;
            }
        }
        for (Set<Character> set : map.values()) {
            for (Character value : set) {
                degrees[value - 'a']++;
            }
        }
        StringBuilder builder = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        // 字符数
        int count = 0;
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] != 0) count++;
            if (degrees[i] == 0) {
                builder.append((char) ('a' + i));
                queue.add((char) ('a' + i));
            }
        }
        while (!queue.isEmpty()) {
            Character poll = queue.poll();
            if (map.containsKey(poll)) {
                Set<Character> set = map.get(poll);
                for (Character c : set) {
                    degrees[c - 'a']--;
                    if (degrees[c - 'a'] == 0) {
                        queue.add(c);
                        builder.append(c);
                    }
                }
            }
        }
        if (builder.length() != count) return "";
        return builder.toString();
    }
}
