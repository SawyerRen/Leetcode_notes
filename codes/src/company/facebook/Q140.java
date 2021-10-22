package company.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q140 {
    Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String sub = s.substring(word.length());
                List<String> nextList = wordBreak(sub, wordDict);
                for (String next : nextList) {
                    if (next.length() == 0) {
                        res.add(word);
                    } else {
                        res.add(word + " " + next);
                    }
                }
            }
        }
        memo.put(s, res);
        return res;
    }
}
