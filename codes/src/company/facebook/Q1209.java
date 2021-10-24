package company.facebook;

import java.util.Map;
import java.util.Stack;

public class Q1209 {
    class Node {
        int count;
        char c;

        public Node(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == c) {
                stack.peek().count++;
                if (stack.peek().count == k) stack.pop();
            } else {
                stack.push(new Node(1, c));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            for (int i = 0; i < pop.count; i++) {
                builder.append(pop.c);
            }
        }
        return builder.reverse().toString();
    }
}
