package all_solution.q0;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        StringBuilder builder = new StringBuilder();
        helper(res, builder, digits, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, String digits, int index) {
        if (index == digits.length()) {
            res.add(builder.toString());
            return;
        }
        char c = digits.charAt(index);
        String str = strs[c - '0'];
        int length = builder.length();
        for (char c1 : str.toCharArray()) {
            builder.append(c1);
            helper(res, builder, digits, index + 1);
            builder.setLength(length);
        }
    }
}
