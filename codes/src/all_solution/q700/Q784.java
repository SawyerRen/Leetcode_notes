package all_solution.q700;

import java.util.ArrayList;
import java.util.List;

public class Q784 {
    public List<String> letterCasePermutation(String s) {
        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            if (Character.isLetter(chars[i])) chars[i] = Character.toLowerCase(chars[i]);
//        }
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), chars, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, char[] chars, int index) {
        if (index == chars.length) {
            res.add(builder.toString());
            return;
        }
        int len = builder.length();
        if (Character.isDigit(chars[index])) {
            helper(res, builder.append(chars[index]), chars, index + 1);
        } else {
            builder.append(Character.toLowerCase(chars[index]));
            helper(res, builder, chars, index + 1);
            builder.setLength(len);
            builder.append(Character.toUpperCase(chars[index]));
            helper(res, builder, chars, index + 1);
            builder.setLength(len);
        }
    }
}
