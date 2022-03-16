package all_solution.q600;

import java.util.*;

public class Q609 {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] split = path.split(" ");
            String dir = split[0];
            for (int i = 1; i < split.length; i++) {
                String s = split[i];
                int index = s.indexOf("(");
                String fileName = s.substring(0, index);
                String content = s.substring(index + 1, s.length() - 1);
                map.putIfAbsent(content, new HashSet<>());
                map.get(content).add(dir + "/" + fileName);
            }
        }
        for (Set<String> set : map.values()) {
            if (set.size() > 1)
                res.add(new ArrayList<>(set));
        }
        return res;
    }
}
