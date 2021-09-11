package all_solution.q200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q212 {
    int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie head = new Trie();
        for (String word : words) {
            head.insert(word);
        }
        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(res, board, i, j, "", new boolean[board.length][board[0].length], head);
            }
        }
        return new ArrayList<>(res);
    }

    private void helper(Set<String> res, char[][] board, int i, int j, String s, boolean[][] visited, Trie head) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return;
        s += board[i][j];
        if (!head.startsWith(s)) return;
        if (head.search(s)) res.add(s);
        for (int[] dir : dirs) {
            visited[i][j] = true;
            helper(res, board, i + dir[0], j + dir[1], s, visited, head);
            visited[i][j] = false;
        }
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
