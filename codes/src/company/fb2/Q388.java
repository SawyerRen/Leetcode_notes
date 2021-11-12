package company.fb2;

import java.util.Stack;

public class Q388 {
    public int lengthLongestPath(String input) {
        String[] split = input.split("\n");
        int res = 0, curLen = 0;
        Stack<Integer> stack = new Stack<>();
        for (String s : split) {
            String cur = s.replaceAll("\t", "");
            int level = s.length() - cur.length();
            while (stack.size() > level) {
                curLen -= stack.pop();
            }
            int len = cur.length() + 1;
            curLen += len;
            if (s.contains(".")) {
                res = Math.max(res, curLen - 1);
            }
            stack.push(len);
        }
        return res;
    }
}
