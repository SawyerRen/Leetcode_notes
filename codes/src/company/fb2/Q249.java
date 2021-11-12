package company.fb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                int diff = s.charAt(i + 1) - s.charAt(i);
                if (diff < 0) diff += 26;
                builder.append(diff).append(",");
            }
            String pattern = builder.toString();
            map.putIfAbsent(pattern, new ArrayList<>());
            map.get(pattern).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
