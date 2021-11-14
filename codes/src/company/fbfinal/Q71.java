package company.fbfinal;

import java.util.LinkedList;
import java.util.Stack;

public class Q71 {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        for (String s : path.split("/")) {
            if (!stack.isEmpty() && s.equals("..")) stack.removeLast();
            else if (s.equals("..") || s.equals(".") || s.equals("")) continue;
            else stack.addLast(s);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append("/").append(stack.removeFirst());
        }
        if (builder.length() == 0) return "/";
        return builder.toString();
    }
}
