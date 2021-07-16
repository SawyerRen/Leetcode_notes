package topics.trie;

public class Q211 {
}

class WordDictionary {
    class Node {
        Node[] children = new Node[26];
        boolean isWord;
    }

    Node head;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        head = new Node();
    }

    public void addWord(String word) {
        Node cur = head;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Node cur = head;
        return helper(word, cur, 0);
    }

    private boolean helper(String word, Node cur, int index) {
        if (index == word.length()) {
            return cur.isWord;
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
            return helper(word, cur, index + 1);
        } else {
            for (Node child : cur.children) {
                if (child == null) continue;
                if (helper(word, child, index + 1)) return true;
            }
            return false;
        }
    }
}