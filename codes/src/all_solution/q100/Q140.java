package all_solution.q100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q140 {
    Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        if (memo.containsKey(s)) return memo.get(s);
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = wordBreak(s.substring(word.length()), wordDict);
                for (String sub : subList) {
                    if (sub.equals("")) {
                        res.add(word);
                    } else {
                        res.add(word + " " + sub);
                    }
                }
            }
        }
        return res;
    }
}
