package company.facebook;

import java.util.LinkedList;
import java.util.Stack;

public class Q71 {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            } else if (s.equals("..") || s.equals(".") || s.equals("")) continue;
            else stack.push(s);
        }
        StringBuilder builder = new StringBuilder();
        if (stack.isEmpty()) return "/";
        while (!stack.isEmpty()) {
            builder.insert(0, "/" + stack.pop());
        }
        return builder.toString();
    }
}
