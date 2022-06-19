package all_solution.q0;

import java.util.LinkedList;

public class Q71 {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        for (String s : path.split("/")) {
            if (!stack.isEmpty() && s.equals("..")) stack.removeLast();
            else if (s.equals("..") || s.equals(".") || s.equals("")) continue;
            else stack.addLast(s);
        }
        if (stack.isEmpty()) return "/";
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append("/").append(stack.removeFirst());
        }
        return builder.toString();
    }
}
