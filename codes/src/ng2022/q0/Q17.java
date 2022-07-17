package ng2022.q0;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        helper(res, new StringBuilder(), digits, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, String digits, int index) {
        if (index == digits.length()) {
            res.add(builder.toString());
            return;
        }
        char c = digits.charAt(index);
        String letter = letters[c - '0'];
        for (char c1 : letter.toCharArray()) {
            builder.append(c1);
            helper(res, builder, digits, index + 1);
            builder.setLength(builder.length() - 1);
        }
    }
}
