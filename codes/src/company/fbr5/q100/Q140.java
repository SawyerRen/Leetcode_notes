package company.fbr5.q100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q140 {
    Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> nextList = wordBreak(s.substring(word.length()), wordDict);
                for (String next : nextList) {
                    if (next.equals("")) {
                        res.add(word);
                    } else {
                        res.add(word + " " + next);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
