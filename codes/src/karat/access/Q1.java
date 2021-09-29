package karat.access;

import java.util.*;

public class Q1 {
    public List<List<String>> invalidBadgeRecords(String[][] records) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> state = new HashMap<>();
        Set<String> invalidEnter = new HashSet<>();
        Set<String> invalidExit = new HashSet<>();
        for (String[] record : records) {
            String name = record[0];
            String action = record[1];
            state.putIfAbsent(name, 0);
            if (action.equals("enter")) {
                if (state.get(name) == 0) {
                    state.put(name, 1);
                } else {
                    invalidEnter.add(name);
                }
            } else if (action.equals("exit")) {
                if (state.get(name) == 1) {
                    state.put(name, 0);
                } else {
                    invalidExit.add(name);
                }
            }
        }
        for (String s : state.keySet()) {
            if (state.get(s) == 1) {
                invalidEnter.add(s);
            }
        }
        res.add(new ArrayList<>(invalidEnter));
        res.add(new ArrayList<>(invalidExit));
        return res;
    }
}
