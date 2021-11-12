package company.fbr5.q200;

import org.w3c.dom.Node;

public class Q208 {
    class Trie {
        class Node {
            Node[] children = new Node[26];
            boolean isWord = false;
        }

        Node head = new Node();

        public Trie() {

        }

        public void insert(String word) {
            Node cur = head;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new Node();
                }
                cur = cur.children[c - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            Node cur = head;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return cur.isWord;
        }

        public boolean startsWith(String prefix) {
            Node cur = head;
            for (char c : prefix.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    return false;
                }
                cur = cur.children[c - 'a'];
            }
            return true;
        }
    }
}
