package company.fbr4.q1000;

public class Q1032 {
    class StreamChecker {
        class Node {
            Node[] children = new Node[26];
            boolean isWord;
        }

        Node root = new Node();
        StringBuilder builder = new StringBuilder();

        public StreamChecker(String[] words) {
            for (String word : words) {
                Node cur = root;
                for (int i = word.length() - 1; i >= 0; i--) {
                    char c = word.charAt(i);
                    if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Node();
                    cur = cur.children[c - 'a'];
                }
                cur.isWord = true;
            }
        }

        public boolean query(char letter) {
            builder.append(letter);
            Node cur = root;
            for (int i = builder.length() - 1; i >= 0; i--) {
                char c = builder.charAt(i);
                if (cur.children[c - 'a'] == null) return false;
                if (cur.children[c - 'a'].isWord) return true;
                cur = cur.children[c - 'a'];
            }
            return false;
        }
    }
}
