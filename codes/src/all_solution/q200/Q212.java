package all_solution.q200;

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
        Set<String> res = new HashSet<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(res, board, trie, i, j, m, n, "", new boolean[m][n]);
            }
        }
        return new ArrayList<>(res);
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void helper(Set<String> res, char[][] board, Trie trie, int i, int j, int m, int n, String s, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) return;
        s += board[i][j];
        if (!trie.startsWith(s)) return;
        if (trie.search(s)) {
            res.add(s);
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            helper(res, board, trie, i + dir[0], j + dir[1], m, n, s, visited);
        }
        visited[i][j] = false;
    }

    class Trie {
        class Node {
            Node[] children = new Node[26];
            boolean isWord;
        }

        Node head;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            head = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node cur = head;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Trie.Node();
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node cur = head;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node cur = head;
            for (char c : prefix.toCharArray()) {
                if (cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
            }
            return true;
        }
    }
}
