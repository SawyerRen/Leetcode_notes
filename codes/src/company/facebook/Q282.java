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
        if (0 == num.length()) {
            if (cur == target) res.add(builder.toString());
            return;
        }
        int len = builder.length();
        for (int j = 0; j < num.length(); j++) {
            if (j > 0 && num.charAt(0) == '0') break;
            long n = Long.parseLong(num.substring(0, j + 1));
            if (len == 0) {
                builder.append(n);
                helper(res, builder, num.substring(j + 1), target, n, n);
                builder.setLength(len);
            } else {
                builder.append("+").append(n);
                helper(res, builder, num.substring(j + 1), target, cur + n, n);
                builder.setLength(len);
                builder.append("-").append(n);
                helper(res, builder, num.substring(j + 1), target, cur - n, -n);
                builder.setLength(len);
                builder.append("*").append(n);
                helper(res, builder, num.substring(j + 1), target, cur - pre + pre * n, pre * n);
                builder.setLength(len);
            }
        }
    }
}
