package company.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strings) {
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < string.length(); i++) {
                int dist = string.charAt(i) - string.charAt(i - 1);
                if (dist < 0) dist += 26;
                builder.append(dist).append(".");
            }
            String key = builder.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(string);
            map.put(key, list);
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    public List<List<String>> groupStrings1(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        int n = strings.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            List<String> list = new ArrayList<>();
            list.add(strings[i]);
            visited[i] = true;
            for (int j = i + 1; j < n; j++) {
                if (visited[j]) continue;
                if (canShift(strings[i], strings[j])) {
                    list.add(strings[j]);
                    visited[j] = true;
                }
            }
            res.add(list);
        }
        return res;
    }

    private boolean canShift(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.length() == 0 || s1.length() == 1) return true;
        int diff = s1.charAt(0) - s2.charAt(0);
        if (diff < 0) diff += 26;
        for (int i = 1; i < s1.length(); i++) {
            int curDiff = s1.charAt(i) - s2.charAt(i);
            if (curDiff < 0) curDiff += 26;
            if (diff != curDiff) return false;
        }
        return true;
    }
}
