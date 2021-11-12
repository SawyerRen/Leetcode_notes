package company.fb2;

public class Q676 {
    class MagicDictionary {
        class Node {
            Node[] children = new Node[26];
            boolean isWord;
        }

        Node root;

        public MagicDictionary() {
            root = new Node();
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
            return helper(cur, searchWord, 0, false);
        }

        private boolean helper(Node cur, String searchWord, int i, boolean change) {
            if (i == searchWord.length()) return cur.isWord && change;
            char c = searchWord.charAt(i);
            if (cur.children[c - 'a'] != null) {
                if (helper(cur.children[c - 'a'], searchWord, i + 1, change)) {
                    return true;
                }
            }
            if (!change) {
                for (int j = 0; j < cur.children.length; j++) {
                    if (c == (char) (j + 'a')) continue;
                    Node child = cur.children[j];
                    if (child != null && helper(child, searchWord, i + 1, true)) return true;
                }
            }
            return false;
        }
    }
}
