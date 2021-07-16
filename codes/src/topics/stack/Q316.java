package topics.stack;

import java.util.Stack;

public class Q316 {
    public String removeDuplicateLetters(String s) {
        int[] hash = new int[26];
        boolean[] visited = new boolean[26];
        // 每个字符出现的次数
        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }
        // 保存字符，保持栈顶的字符始终是可能的最小的字符
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            hash[index]--;
            // 如果已经有这个字符，跳过
            if (visited[index]) continue;
            visited[index] = true;
            // 如果这个字符小于栈顶的字符，并且栈顶的字符在后续的字符串中还有，则弹出
            while (!stack.isEmpty() && c < stack.peek() && hash[stack.peek() - 'a'] > 0) {
                Character pop = stack.pop();
                visited[pop - 'a'] = false;
            }
            stack.push(c);
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.insert(0, stack.pop());
        }
        return builder.toString();
    }
}
