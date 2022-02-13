package all_solution.q200;

public class Q211 {
}

class WordDictionary {
    class Node {
        Node[] children = new Node[26];
        boolean isWord;
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Node cur = root;
        return helper(cur, word, 0);
    }

    private boolean helper(Node cur, String word, int index) {
        if (index == word.length()) {
            return cur.isWord;
        }
        char c = word.charAt(index);
        if (c != '.') {
            if (cur.children[c - 'a'] == null) return false;
            return helper(cur.children[c - 'a'], word, index + 1);
        } else {
            for (Node child : cur.children) {
                if (child == null) continue;
                if (helper(child, word, index + 1)) return true;
            }
        }
        return false;
    }
}