package company.fb2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Q399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        buildMap(map, values, equations);
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            res[i] = helper(queries.get(i).get(0), queries.get(i).get(1), map, new HashSet<String>());
        }
        return res;
    }

    private double helper(String start, String end, Map<String, Map<String, Double>> map, HashSet<String> visited) {
        if (!map.containsKey(start)) return -1.0;
        if (map.get(start).containsKey(end)) return map.get(start).get(end);
        visited.add(start);
        for (String next : map.get(start).keySet()) {
            if (visited.contains(next)) continue;
            double res = helper(next, end, map, visited);
            if (res != -1.0) {
                return res * map.get(start).get(next);
            }
        }
        return -1.0;
    }

    private void buildMap(Map<String, Map<String, Double>> map, double[] values, List<List<String>> equations) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String u = equation.get(0), v = equation.get(1);
            map.putIfAbsent(u, new HashMap<>());
            map.get(u).put(v, values[i]);
            map.putIfAbsent(v, new HashMap<>());
            map.get(v).put(u, 1 / values[i]);
        }
    }
}
