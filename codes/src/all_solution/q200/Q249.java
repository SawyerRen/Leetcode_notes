package all_solution.q200;

import java.util.ArrayList;
import java.util.List;

public class Q249 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        boolean[] visited = new boolean[strings.length];
        for (int i = 0; i < strings.length; i++) {
            if (visited[i]) continue;
            ArrayList<String> list = new ArrayList<>();
            list.add(strings[i]);
            visited[i] = true;
            for (int j = i + 1; j < strings.length; j++) {
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
        if (s1.length() == 1) return true;
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
