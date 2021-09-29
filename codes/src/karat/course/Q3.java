package karat.course;

import java.util.*;

public class Q3 {
    public static Set<String> halfWayLessons(String[][] courses) {
        Set<String> res = new HashSet<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, Integer> courseCount = new HashMap<>();
        for (String[] c : courses) {
            graph.putIfAbsent(c[0], new HashSet<>());
            graph.get(c[0]).add(c[1]);
            courseCount.putIfAbsent(c[0], 0);
            courseCount.put(c[1], courseCount.getOrDefault(c[1], 0) + 1);
        }
        for (String course : courseCount.keySet()) {
            if (courseCount.get(course) == 0) {
                List<String> path = new ArrayList<>();
                path.add(course);
                helper(res, graph, path, course);
            }
        }
        return res;
    }

    private static void helper(Set<String> res, Map<String, Set<String>> graph, List<String> path, String course) {
        if (graph.get(course).size() == 0) {
            String halfwayCourse = path.get((path.size() - 1) / 2);
            res.add(halfwayCourse);
            return;
        }
        for (String next : graph.get(course)) {
            path.add(next);
            helper(res, graph, path, next);
            path.remove(path.size() - 1);
        }
    }
}
