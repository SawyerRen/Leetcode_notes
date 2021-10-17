package company.facebook;

import java.util.ArrayList;
import java.util.List;

public class Q282 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num.length() == 0) return res;
        helper(res, new StringBuilder(), num, target, 0, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, String num, int target, long cur, long pre) {
        if (num.length() == 0) {
            if (cur == target) res.add(builder.toString());
            return;
        }
        int length = builder.length();
        for (int i = 0; i < num.length(); i++) {
            if (i > 0 && num.charAt(i) == '0') break;
            long sub = Long.parseLong(num.substring(0, i + 1));
            if (length == 0) {
                builder.append(sub);
                helper(res, builder, num.substring(i + 1), target, sub, sub);
                builder.setLength(length);
            } else {
                builder.append("+").append(sub);
                helper(res, builder, num.substring(i + 1), target, cur + sub, sub);
                builder.setLength(length);
                builder.append("-").append(sub);
                helper(res, builder, num.substring(i + 1), target, cur - sub, -sub);
                builder.setLength(length);
                builder.append("*").append(sub);
                helper(res, builder, num.substring(i + 1), target, cur - pre + pre * sub, pre * sub);
                builder.setLength(length);
            }
        }
    }
}
