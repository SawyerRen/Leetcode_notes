package all_solution.q0;

import java.util.LinkedList;
import java.util.Stack;

public class Q71 {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (String s : split) {
            if (!stack.isEmpty() && s.equals("..")) {
                stack.removeLast();
            } else if (s.equals(".") || s.equals("..") || s.equals("")) {
                continue;
            } else {
                stack.addLast(s);
            }
        }
        if (stack.size() == 0) return "/";
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append("/").append(stack.pollFirst());
        }
        return builder.toString();
    }
}
