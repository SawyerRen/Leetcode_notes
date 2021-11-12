package company.fbr5.q0;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wyxz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        helper(res, new StringBuilder(), digits, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, String digits, int i) {
        if (i == digits.length()) {
            res.add(builder.toString());
            return;
        }
        int index = digits.charAt(i) - '0';
        for (char c : strs[index].toCharArray()) {
            builder.append(c);
            helper(res, builder, digits, i + 1);
            builder.setLength(builder.length() - 1);
        }
    }
}
