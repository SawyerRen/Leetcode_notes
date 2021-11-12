package company.fbr5.q0;

import java.util.LinkedList;
import java.util.Stack;

public class Q71 {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (String s : split) {
            if (!stack.isEmpty() && s.equals("..")) stack.removeLast();
            else if (s.equals("..") || s.equals(".") || s.equals("")) continue;
            else stack.addLast(s);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append("/").append(stack.pollFirst());
        }
        if (builder.length() == 0) return "/";
        return builder.toString();
    }
}
