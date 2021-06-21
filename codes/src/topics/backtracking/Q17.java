package topics.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        helper(res, digits, new StringBuilder(), 0);
        return res;
    }

    private void helper(List<String> res, String digits, StringBuilder builder, int index) {
        int len = builder.length();
        if (digits.length() == index) {
            res.add(builder.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letter = letters[digit];
        for (char c : letter.toCharArray()) {
            builder.append(c);
            helper(res, digits, builder, index + 1);
            builder.setLength(len);
        }
    }
}
