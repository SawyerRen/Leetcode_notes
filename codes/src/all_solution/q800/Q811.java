package all_solution.q800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            int count = Integer.parseInt(split[0]);
            String domain = split[1];
            String[] split1 = domain.split("\\.");
            StringBuilder builder = new StringBuilder();
            for (int i = split1.length - 1; i >= 0; i--) {
                if (builder.length() == 0) builder.append(split1[i]);
                else builder.insert(0, split1[i] + ".");
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
