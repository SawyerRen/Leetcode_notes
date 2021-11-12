package company.fb2;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

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
                visited[list.removeLast() - 'a'] = false;
            }
            list.addLast(c);
            visited[c - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        while (list.size() > 0) {
            builder.append(list.pollFirst());
        }
        return builder.toString();
    }
}
