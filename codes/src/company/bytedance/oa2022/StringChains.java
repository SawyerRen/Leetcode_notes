package company.bytedance.oa2022;

import java.util.*;

public class StringChains {
    static int solution(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"a", "and", "an", "bear"};
        System.out.println(solution(words));

    }
}
