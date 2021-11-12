package company.fbr5.q0;

import java.util.ArrayList;
import java.util.List;

public class Q93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), s, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder builder, String s, int count) {
        if (count == 4) {
            if (s.length() == 0) res.add(builder.toString());
            return;
        }
        int len = builder.length();
        for (int i = 0; i < 3 && i < s.length(); i++) {
            if (i > 0 && s.charAt(0) == '0') break;
            int sub = Integer.parseInt(s.substring(0, i + 1));
            if (sub < 256) {
                if (builder.length() == 0) {
                    builder.append(sub);
                } else {
                    builder.append(".").append(sub);
                }
                helper(res, builder, s.substring(i + 1), count + 1);
                builder.setLength(len);
            }
        }
    }
}
