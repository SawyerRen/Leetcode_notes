package company.fbr5.again;

import java.util.Stack;

public class Q388 {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        String[] split = input.split("\n");
        int res = 0;
        for (String s : split) {
            int numOfTabs = s.lastIndexOf("\t") + 1;
            int level = numOfTabs + 1;
            while (stack.size() > level) stack.pop();
            int curLen = stack.peek() + s.length() - numOfTabs + 1;
            if (s.contains(".")) res = Math.max(res, curLen - 1);
            stack.push(curLen);
        }
        return res;
    }
}
