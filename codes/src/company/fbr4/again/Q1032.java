package company.fbr4.again;

public class Q1032 {
    class StreamChecker {
        class Node {
            Node[] children = new Node[26];
            boolean isWord = false;
        }

        Node root = new Node();

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

        StringBuilder builder = new StringBuilder();

        public boolean query(char letter) {
            builder.append(letter);
            Node cur = root;
            for (int i = builder.length() - 1; i >= 0; i--) {
                char c = builder.charAt(i);
                if (cur.children[c - 'a'] == null) return false;
                cur = cur.children[c - 'a'];
                if (cur.isWord) return true;
            }
            return false;
        }
    }
}
