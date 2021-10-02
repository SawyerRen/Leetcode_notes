package company.bytedance.interview;

import java.util.ArrayList;
import java.util.List;

/*
Another version of https://leetcode.com/problems/restore-ip-addresses/ was asked.
Here, we have to divide given string in (default) 4 parts.
In the interview, I had to divide it in k parts.
Rest all conditions remain same.
 */
public class Q2 {
    public List<String> restoreIpAddresses(String s, int k) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), s, 0, k);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, String s, int count, int k) {
        if (count == k) {
            if (s.length() == 0) res.add(builder.toString());
            return;
        }
        int len = builder.length();
        for (int i = 0; i < 3 && i < s.length(); i++) {
            if (i > 0 && s.charAt(0) == '0') break;
            String sub = s.substring(0, i + 1);
            int num = Integer.parseInt(sub);
            if (num >= 0 && num <= 255) {
                if (len == 0) {
                    builder.append(sub);
                } else {
                    builder.append('.').append(sub);
                }
                helper(res, builder, s.substring(i + 1), count + 1, k);
                builder.setLength(len);
            }
        }
    }
}
