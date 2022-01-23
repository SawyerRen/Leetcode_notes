package all_solution.q0;

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
            int num = Integer.parseInt(s.substring(0, i + 1));
            if (0 <= num && num <= 255) {
                if (len == 0) builder.append(num);
                else builder.append('.').append(num);
                helper(res, builder, s.substring(i + 1), count + 1);
                builder.setLength(len);
            }
        }
    }
}
