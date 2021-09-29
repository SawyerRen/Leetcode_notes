package karat.wordprocessor;

import java.util.ArrayList;
import java.util.List;

public class Q1 {
    public List<String> wordWrap(List<String> words, int maxLen) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.size()) {
            int remain = maxLen;
            int count = 0;
            while (i < words.size()) {
                if (remain < words.get(i).length()) break;
                remain -= words.get(i).length();
                i++;
                count++;
            }
            StringBuilder builder = new StringBuilder();
            for (int j = i - count; j < i; j++) {
                if (builder.length() == 0) builder.append(words.get(j));
                else builder.append("-").append(words.get(j));
            }
            res.add(builder.toString());
        }
        return res;
    }
}
