package company.fbfinal;

import java.util.LinkedList;
import java.util.Stack;

public class Q1209 {
    public String removeDuplicates(String s, int k) {
        LinkedList<Node> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!list.isEmpty() && c == list.getLast().ch) {
                list.getLast().count++;
                if (list.getLast().count == k) list.removeLast();
            } else {
                list.addLast(new Node(1, c));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!list.isEmpty()) {
            Node node = list.removeFirst();
            for (int i = 0; i < node.count; i++) {
                builder.append(node.ch);
            }
        }
        return builder.toString();
    }

    class Node {
        int count;
        char ch;

        public Node(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }
    }
}
