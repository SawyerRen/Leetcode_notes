package all_solution.q300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Q399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        buildMap(map, equations, values);
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = helper(map, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
        }
        return res;
    }

    private double helper(Map<String, Map<String, Double>> map, String start, String end, HashSet<String> visited) {
        if (!map.containsKey(start)) return -1.0;
        if (map.get(start).containsKey(end)) return map.get(start).get(end);
        for (String next : map.get(start).keySet()) {
            if (visited.contains(next)) continue;
            visited.add(next);
            double v = helper(map, next, end, visited);
            if (v != -1.0) {
                return map.get(start).get(next) * v;
            }
            visited.remove(next);
        }
        return -1.0;
    }

    private void buildMap(Map<String, Map<String, Double>> map, List<List<String>> equations, double[] values) {
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            map.putIfAbsent(u, new HashMap<>());
            map.putIfAbsent(v, new HashMap<>());
            map.get(u).put(v, values[i]);
            map.get(v).put(u, 1 / values[i]);
        }
    }
}
