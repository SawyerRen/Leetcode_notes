package all_solution.q200;

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
                int diff = string.charAt(i) - string.charAt(i - 1);
                if (diff < 0) diff += 26;
                builder.append(diff).append(",");
            }
            map.putIfAbsent(builder.toString(), new ArrayList<>());
            map.get(builder.toString()).add(string);
        }
        return new ArrayList<>(map.values());
    }
}
