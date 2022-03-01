package all_solution.q300;

import java.util.LinkedList;

public class Q316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean[] visited = new boolean[26];
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (visited[c - 'a']) continue;
            while (!list.isEmpty() && c < list.getLast() && count[list.getLast() - 'a'] > 0) {
                Character last = list.removeLast();
                visited[last - 'a'] = false;
            }
            list.addLast(c);
            visited[c - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        for (Character c : list) {
            builder.append(c);
        }
        return builder.toString();
    }
}
