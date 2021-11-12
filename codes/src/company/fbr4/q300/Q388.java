package company.fbr4.q300;

import java.util.Stack;

public class Q388 {
    public int lengthLongestPath(String input) {
        String[] split = input.split("\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (String s : split) {
            int numTabs = s.lastIndexOf("\t") + 1;
            int level = numTabs + 1;
            while (level < stack.size()) {
                stack.pop();
            }
            int curLen = stack.peek() + s.length() - numTabs + 1;
            stack.push(curLen);
            if (s.contains(".")) res = Math.max(res, curLen - 1);
        }
        return res;
    }
}
