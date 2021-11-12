package company.fb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1) list.add(s);
        }
        return list.toArray(new String[0]);
    }
}
