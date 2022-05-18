package all_solution.q1800;

import java.util.HashMap;
import java.util.Map;

public class Q1859 {
    public String sortSentence(String s) {
        String[] split = s.split(" ");
        Map<Integer, String> map = new HashMap<>();
        for (String s1 : split) {
            int index = s1.charAt(s1.length() - 1) - '0';
            map.put(index, s1.substring(0, s1.length() - 1));
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i == split.length - 1) {
                builder.append(map.get(i + 1));
            } else {
                builder.append(map.get(i + 1)).append(" ");
            }
        }
        return builder.toString();
    }
}
