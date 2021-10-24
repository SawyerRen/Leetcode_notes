package company.facebook;

import java.util.LinkedList;
import java.util.Stack;

public class Q71 {
    // N    N
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            if (!stack.isEmpty() && s.equals("..")) stack.pop();
            else if (s.equals(".") || s.equals("..") || s.equals("")) continue;
            else stack.push(s);
        }
        if (stack.isEmpty()) return "/";
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, "/" + stack.pop());
        }
        return builder.toString();
    }
}
