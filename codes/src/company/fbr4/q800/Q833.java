package company.fbr4.q800;

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
        int index = 0;
        while (index < s.length()) {
            if (!map.containsKey(index)) {
                builder.append(s.charAt(index++));
            } else {
                String source = sources[map.get(index)];
                String target = targets[map.get(index)];
                builder.append(target);
                index += source.length();
            }
        }
        return builder.toString();
    }
}
