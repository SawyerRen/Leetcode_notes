package frequency.q200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q212 {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length, n = board[0].length;
        Set<String> res = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(board, i, j, m, n, trie, res, "", new boolean[m][n]);
            }
        }
        return new ArrayList<>(res);
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void helper(char[][] board, int i, int j, int m, int n, Trie trie, Set<String> res, String s, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        s += board[i][j];
        if (!trie.startsWith(s)) return;
        if (trie.search(s)) res.add(s);
        visited[i][j] = true;
        for (int[] dir : dirs) {
            helper(board, i + dir[0], j + dir[1], m, n, trie, res, s, visited);
        }
        visited[i][j] = false;
    }

    class Trie {
        class Node {
            Node[] children = new Node[26];
            boolean isWord;
        }

        Node root = new Node();

        public Trie() {

        }

        public void insert(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }

        public boolean startsWith(String prefix) {
            Node cur = root;
            for (char c : prefix.toCharArray()) {
                if (cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
            }
            return true;
        }
    }
}
