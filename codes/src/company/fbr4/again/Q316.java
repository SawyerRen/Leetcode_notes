package company.fbr4.again;

import java.util.LinkedList;

public class Q316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        boolean[] visited = new boolean[26];
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']--;
            if (visited[c - 'a']) continue;
            while (!list.isEmpty() && list.getLast() > c && count[list.getLast() - 'a'] > 0) {
                visited[list.getLast() - 'a'] = false;
                list.removeLast();
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
