package company.fbr3;

import java.util.Stack;

public class Q1209 {
    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek().ch) {
                stack.peek().count++;
                if (stack.peek().count == k) stack.pop();
            } else {
                stack.push(new Node(c, 1));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            for (int i = 0; i < pop.count; i++) {
                builder.append(pop.ch);
            }
        }
        return builder.reverse().toString();
    }

    class Node {
        char ch;
        int count;

        public Node(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
