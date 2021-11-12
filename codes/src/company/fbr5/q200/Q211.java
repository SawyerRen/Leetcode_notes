package company.fbr5.q200;

public class Q211 {
    class WordDictionary {
        class Node {
            Node[] children = new Node[26];
            boolean isWord = false;
        }

        Node root = new Node();

        public WordDictionary() {

        }

        public void addWord(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            Node cur = root;
            return helper(cur, word, 0);
        }

        private boolean helper(Node cur, String word, int i) {
            if (i == word.length()) return cur.isWord;
            char c = word.charAt(i);
            if (c == '.') {
                for (Node child : cur.children) {
                    if (child != null) {
                        if (helper(child, word, i + 1)) return true;
                    }
                }
            } else {
                if (cur.children[c - 'a'] == null) return false;
                return helper(cur.children[c - 'a'], word, i + 1);
            }
            return false;
        }
    }
}
