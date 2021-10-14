package company.facebook;

import java.util.LinkedList;
import java.util.Stack;

public class Q71 {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        String[] split = path.split("/");
        for (String s : split) {
            if (!stack.isEmpty() && s.equals("..")) stack.pollLast();
            else if (!s.equals("") && !s.equals(".") && !s.equals("..")) stack.addLast(s);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append("/").append(stack.pollFirst());
        }
        if (builder.length() == 0) return "/";
        return builder.toString();
    }
}
