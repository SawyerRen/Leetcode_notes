package all_solution.q400;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        List<String> res = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            if (word.length() > 0) {
                if (trie.exist(word, 0)) res.add(word);
                else trie.insert(word);
            }
        }
        return res;
    }

    static class Trie {
        static class Node {
            Node[] children = new Node[26];
            boolean isWord;
        }

        Node root = new Node();

        void insert(String s) {
            Node cur = root;
            for (char c : s.toCharArray()) {
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        boolean exist(String s, int start) {
            if (start == s.length()) return true;
            Node cur = root;
            for (int i = start; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
                if (cur.isWord) {
                    if (exist(s, i + 1)) return true;
                }
            }
            return false;
        }
    }
}
