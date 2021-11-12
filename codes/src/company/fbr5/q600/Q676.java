package company.fbr5.q600;

public class Q676 {
    class MagicDictionary {
        class Node {
            Node[] children = new Node[26];
            boolean isWord = false;
        }

        Node root = new Node();

        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                Node cur = root;
                for (char c : s.toCharArray()) {
                    if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
                    cur = cur.children[c - 'a'];
                }
                cur.isWord = true;
            }
        }

        public boolean search(String searchWord) {
            Node cur = root;
            return helper(searchWord, cur, 0, false);
        }

        private boolean helper(String word, Node cur, int i, boolean change) {
            if (i == word.length()) {
                return cur.isWord && change;
            }
            char c = word.charAt(i);
            if (cur.children[c - 'a'] != null) {
                if (helper(word, cur.children[c - 'a'], i + 1, change)) return true;
            }
            if (!change) {
                for (int j = 0; j < cur.children.length; j++) {
                    if (c == (char) (j + 'a')) continue;
                    if (cur.children[j] != null) {
                        if (helper(word, cur.children[j], i + 1, true)) return true;
                    }
                }
            }
            return false;
        }
    }
}
