package frequency.q800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int count = Integer.parseInt(cpdomain.split(" ")[0]);
            String domain = cpdomain.split(" ")[1];
            String[] split = domain.split("\\.");
            StringBuilder builder = new StringBuilder();
            for (int i = split.length - 1; i >= 0; i--) {
                if (builder.length() == 0) builder.append(split[i]);
                else builder.insert(0, split[i] + ".");
                map.put(builder.toString(), map.getOrDefault(builder.toString(), 0) + count);
            }
        }
        List<String> res = new ArrayList<>();
        for (String s : map.keySet()) {
            res.add(map.get(s) + " " + s);
        }
        return res;
    }
}
