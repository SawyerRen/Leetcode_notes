package all_solution.q1200;

import java.util.Stack;

public class Q1209 {
    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek().ch) {
                stack.peek().count++;
                if (stack.peek().count == k) stack.pop();
            } else {
                stack.push(new Node(c));
            }
        }
        StringBuilder builder = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            builder.append(String.valueOf(pop.ch).repeat(Math.max(0, pop.count)));
        }
        return builder.reverse().toString();
    }

    class Node {
        char ch;
        int count;

        public Node(char c) {
            this.ch = c;
            this.count = 1;
        }
    }
}
