package frequency.q200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q244 {
    class WordDistance {
        Map<String, List<Integer>> map;

        public WordDistance(String[] wordsDict) {
            map = new HashMap<>();
            for (int i = 0; i < wordsDict.length; i++) {
                map.putIfAbsent(wordsDict[i], new ArrayList<>());
                map.get(wordsDict[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            int i = 0, j = 0;
            int res = Integer.MAX_VALUE;
            while (i < list1.size() && j < list2.size()) {
                int index1 = list1.get(i);
                int index2 = list2.get(j);
                if (index1 < index2) {
                    res = Math.min(res, index2 - index1);
                    i++;
                } else {
                    res = Math.min(res, index1 - index2);
                    j++;
                }
            }
            return res;
        }
    }
}
