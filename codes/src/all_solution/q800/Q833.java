package all_solution.q800;

import java.util.HashMap;
import java.util.Map;

public class Q833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            if (s.startsWith(sources[i], indices[i])) {
                map.put(indices[i], i);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(i)) {
                builder.append(targets[map.get(i)]);
                i += sources[map.get(i)].length() - 1;
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
