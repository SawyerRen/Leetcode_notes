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
            for (int i = 0; i < string.length() - 1; i++) {
                int diff = string.charAt(i + 1) - string.charAt(i);
                if (diff < 0) diff += 26;
                builder.append(diff).append(",");
            }
            String pattern = builder.toString();
            map.putIfAbsent(pattern, new ArrayList<>());
            map.get(pattern).add(string);
        }
        return new ArrayList<>(map.values());
    }
}
