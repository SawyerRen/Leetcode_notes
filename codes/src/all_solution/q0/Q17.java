package all_solution.q0;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        helper(res, digits, 0, new StringBuilder());
        return res;
    }

    private void helper(List<String> res, String digits, int index, StringBuilder builder) {
        if (index == digits.length()) {
            res.add(builder.toString());
            return;
        }
        int length = builder.length();
        char c = digits.charAt(index);
        for (char c1 : letters[c - '0'].toCharArray()) {
            builder.append(c1);
            helper(res, digits, index + 1, builder);
            builder.setLength(length);
        }
    }
}
