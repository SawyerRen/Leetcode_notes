package all_solution.q0;

import java.util.Stack;

public class Q71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (String s : split) {
            if (!stack.isEmpty() && s.equals("..")) stack.pop();
            else if (s.equals("") || s.equals(".") || s.equals("..")) continue;
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
