package topics.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Q282 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num.length() == 0) return res;
        helper(res, num, target, new StringBuilder(), 0, 0);
        return res;
    }

    // cur指当前数值,pre指builder的最后一个数值
    private void helper(List<String> res, String s, int target, StringBuilder builder, long cur, long pre) {
        if (s.length() == 0) {
            if (cur == target) res.add(builder.toString());
            return;
        }
        int len = builder.length();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(0) == '0') break;
            long sub = Long.parseLong(s.substring(0, i + 1));
            if (len == 0) {
                builder.append(sub);
                helper(res, s.substring(i + 1), target, builder, sub, sub);
                builder.setLength(len);
            } else {
                builder.append("+").append(sub);
                helper(res, s.substring(i + 1), target, builder, cur + sub, sub);
                builder.setLength(len);
                builder.append("-").append(sub);
                helper(res, s.substring(i + 1), target, builder, cur - sub, -sub);
                builder.setLength(len);
                builder.append("*").append(sub);
                helper(res, s.substring(i + 1), target, builder, cur - pre + pre * sub, pre * sub);
                builder.setLength(len);
            }
        }
    }
}
