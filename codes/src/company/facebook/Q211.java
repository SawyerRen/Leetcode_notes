package company.facebook;

public class Q211 {
}

class WordDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    TrieNode head;

    public WordDictionary() {
        head = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = head;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = head;
        return helper(cur, word, 0);
    }

    private boolean helper(TrieNode cur, String word, int index) {
        if (index == word.length()) return cur.isWord;
        char c = word.charAt(index);
        if (c != '.') {
            if (cur.children[c - 'a'] == null) return false;
            return helper(cur.children[c - 'a'], word, index + 1);
        } else {
            for (TrieNode child : cur.children) {
                if (child != null && helper(child, word, index + 1)) return true;
            }
        }
        return false;
    }
}
