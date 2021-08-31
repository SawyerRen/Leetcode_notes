package topics.tree;

import java.util.Stack;

public class Q331 {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        String[] split = preorder.split(",");
        for (String s : split) {
            while (s.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(s);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
