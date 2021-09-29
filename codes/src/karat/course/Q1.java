package karat.course;

import java.util.*;

public class Q1 {
    public static Map<String[], String[]> findPairs(String[][] coursePairs) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] coursePair : coursePairs) {
            Set<String> set = map.getOrDefault(coursePair[0], new HashSet<>());
            set.add(coursePair[1]);
            map.put(coursePair[0], set);
        }
        List<String> students = new ArrayList<>(map.keySet());
        Map<String[], String[]> res = new HashMap<>();
        for (int i = 0; i < students.size(); i++) {
            for (int j = i + 1; j < students.size(); j++) {
                String s1 = students.get(i);
                String s2 = students.get(j);
                Set<String> courses = map.get(s1);
                List<String> shareCourses = new ArrayList<>();
                for (String c1 : courses) {
                    if (map.get(s2).contains(c1)) shareCourses.add(c1);
                }
                String[] strings = new String[shareCourses.size()];
                for (int k = 0; k < strings.length; k++) {
                    strings[k] = shareCourses.get(k);
                }
                res.put(new String[]{s1, s2}, strings);
            }
        }
        return res;
    }
}
