package karat.course;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q2 {
    public static String findMediumCourse1(String[][] courses) {
        Map<String, String> graph = new HashMap<>();
        Map<String, Integer> preCount = new HashMap<>();
        for (String[] course : courses) {
            graph.put(course[0], course[1]);
            preCount.put(course[1], preCount.getOrDefault(course[1], 0) + 1);
        }
        String startCourse = "";
        for (String course : graph.keySet()) {
            if (!preCount.containsKey(course)) {
                startCourse = course;
                break;
            }
        }
        int size = graph.keySet().size() + 1;
        int step = (size - 1) / 2;
        for (int i = 0; i < step; i++) {
            startCourse = graph.get(startCourse);
        }
        return startCourse;
    }
}
