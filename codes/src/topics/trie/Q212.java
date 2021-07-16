package topics.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q212 {
    static class Node {
        Node[] children = new Node[26];
        boolean isWord;
    }

    Node head = new Node();
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        int m = board.length;
        if (m == 0) return new ArrayList<>(res);
        int n = board[0].length;
        // 将单词插入前缀树
        for (String word : words) {
            insert(word);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(res, "", board, new boolean[m][n], i, j);
            }
        }
        return new ArrayList<>(res);
    }

    private void helper(Set<String> res, String s, char[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length || visited[i][j]) return;
        s += board[i][j];
        if (!startWith(s)) return;
        if (exists(s)) {
            res.add(s);
        }
        for (int[] dir : dirs) {
            visited[i][j] = true;
            helper(res, s, board, visited, i + dir[0], j + dir[1]);
            visited[i][j] = false;
        }
    }

    void insert(String word) {
        Node cur = head;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    boolean startWith(String prefix) {
        Node cur = head;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }

    boolean exists(String word) {
        Node cur = head;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }
}
