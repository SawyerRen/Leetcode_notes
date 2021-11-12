package company.fbr4.q300;

import java.util.LinkedList;

public class Q316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        LinkedList<Character> list = new LinkedList<>();
        boolean[] visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']--;
            if (visited[c - 'a']) continue;
            while (!list.isEmpty() && c < list.getLast() && count[list.getLast() - 'a'] > 0) {
                visited[list.getLast() - 'a'] = false;
                list.removeLast();
            }
            list.addLast(c);
            visited[c - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        while (!list.isEmpty()) {
            builder.append(list.removeFirst());
        }
        return builder.toString();
    }
}
