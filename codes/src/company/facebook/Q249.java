package company.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q249 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < string.length(); i++) {
                int diff = string.charAt(i) - string.charAt(i - 1);
                if (diff < 0) diff += 26;
                list.add(diff);
            }
            map.putIfAbsent(list.toString(), new ArrayList<>());
            map.get(list.toString()).add(string);
        }
        res.addAll(map.values());
        return res;
    }
}
