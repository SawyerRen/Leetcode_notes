package frequency.q200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q212 {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper(res, trie, board, i, j, "", m, n, new boolean[m][n]);
            }
        }
        return new ArrayList<>(res);
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void helper(Set<String> res, Trie trie, char[][] board, int i, int j, String s, int m, int n, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;
        s += board[i][j];
        if (!trie.startsWith(s)) return;
        if (trie.search(s)) res.add(s);
        visited[i][j] = true;
        for (int[] dir : dirs) {
            helper(res, trie, board, i + dir[0], j + dir[1], s, m, n, visited);
        }
        visited[i][j] = false;
    }

    class Trie {
        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isWord = false;
        }

        TrieNode root = new TrieNode();

        void insert(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        boolean search(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null)
                    return false;
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }

        boolean startsWith(String s) {
            TrieNode cur = root;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null)
                    return false;
                cur = cur.children[c - 'a'];
            }
            return true;
        }
    }
}
