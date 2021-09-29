package karat.wordprocessor;

import java.util.ArrayList;
import java.util.List;

public class Q2 {
    public List<String> reflowAndJustify(List<String> lines, int maxLen) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (String line : lines) {
            s.append(line).append(" ");
        }
        String[] words = s.toString().split(" ");
        int i = 0;
        while (i < words.length) {
            int len = 0;
            int count = 0;
            while (i < words.length && len < maxLen) {
                len += words[i].length();
                i++;
                count++;
            }
            int remain = maxLen - len;
            int basic = remain / (count - 1);
            int mod = remain % (count - 1);
            StringBuilder builder = new StringBuilder();
            for (int j = i - count; j < i; j++) {
                if (builder.length() == 0) builder.append(words[j]);
                else if (mod > 0) {
                    builder.append("-".repeat(Math.max(0, basic + 1)));
                    builder.append(words[j]);
                } else {
                    builder.append("-".repeat(Math.max(0, basic)));
                    builder.append(words[j]);
                }
            }
            res.add(builder.toString());
        }
        return res;
    }
}
