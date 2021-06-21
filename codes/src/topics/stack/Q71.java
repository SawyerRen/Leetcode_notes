package topics.stack;

import java.util.Stack;

public class Q71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String s : path.split("/")) {
            if (!stack.isEmpty() && s.equals("..")) stack.pop();
            else if (s.equals("..") || s.equals(".") || s.equals("")) {
            }
            else stack.push(s);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, "/" + stack.pop());
        }
        if (builder.length() == 0) return "/";
        return builder.toString();
    }
}
