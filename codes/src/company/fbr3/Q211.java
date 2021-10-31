package company.fbr3;

public class Q211 {
}

class WordDictionary {
    class Node {
        Node[] children = new Node[26];
        boolean isWord;
    }

    Node head;

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
        return helper(cur, word, 0);
    }

    private boolean helper(Node cur, String word, int i) {
        if (i == word.length()) return cur.isWord;
        char c = word.charAt(i);
        if (c != '.') {
            if (cur.children[c - 'a'] == null) return false;
            return helper(cur.children[c - 'a'], word, i + 1);
        } else {
            for (Node child : cur.children) {
                if (child != null) {
                    if (helper(child, word, i + 1)) return true;
                }
            }
        }
        return false;
    }
}