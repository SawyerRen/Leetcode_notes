package company.facebook;

public class Q208 {
}

class Trie {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    TrieNode head;

    public Trie() {
        head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = head;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null)
                cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = head;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null)
                return false;
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = head;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null)
                return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }
}