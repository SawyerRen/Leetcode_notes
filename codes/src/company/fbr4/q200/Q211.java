package company.fbr4.q200;

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
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            Node cur = root;
            return searchWord(cur, word, 0);
        }

        private boolean searchWord(Node cur, String word, int index) {
            if (cur == null) return false;
            if (index == word.length()) {
                return cur.isWord;
            }
            char c = word.charAt(index);
            if (c == '.') {
                for (Node child : cur.children) {
                    if (searchWord(child, word, index + 1)) return true;
                }
            } else {
                return searchWord(cur.children[c - 'a'], word, index + 1);
            }
            return false;
        }
    }
}
