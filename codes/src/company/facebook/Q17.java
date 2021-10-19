package company.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), digits, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, String digits, int i) {
        if (i == digits.length()) {
            res.add(builder.toString());
            return;
        }
        int length = builder.length();
        for (char c : strings[digits.charAt(i) - '0'].toCharArray()) {
            builder.append(c);
            helper(res, builder, digits, i + 1);
            builder.setLength(length);
        }
    }
}
