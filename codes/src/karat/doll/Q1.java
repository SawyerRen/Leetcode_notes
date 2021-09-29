package karat.doll;

import java.util.*;

public class Q1 {
    boolean ifDollPossible(String[][] input, String[][] partialDoll) {
        Map<String, List<String>> adjList = getAdjListFull(input);
        Set<String> partialDollNodes = new HashSet<>();
        for (int i = 0; i < partialDoll.length; i++) {
            String src = partialDoll[i][0];
            partialDollNodes.add(src);
            String dst = null;
            if (partialDoll[i].length > 1) {
                dst = partialDoll[i][1];
            }
            if (dst != null)
                partialDollNodes.add(dst);
        }
        for (String key : adjList.keySet()) {
            if (partialDollNodes.add(key)) {
                return false;
            }
        }
        for (int i = 0; i < partialDoll.length; i++) {
            if (partialDoll[i].length == 1) {
                continue;
            }
            if (!adjList.get(partialDoll[i][0]).contains(partialDoll[i][1])) {
                return false;
            }
        }

        return true;

    }

    private static Map<String, List<String>> getAdjListFull(String[][] input) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> list;
        Set<String> nodes = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            String src = input[i][0];
            String dst = input[i][1];
            nodes.add(src);
            nodes.add(dst);
        }
        for (String node : nodes) {
            list = map.getOrDefault(node, new ArrayList<>());
            for (int i = 0; i < input.length; i++) {
                String src = input[i][0];
                String dst = input[i][1];
                if (node.equals(src)) {

                    list.add(dst);
                }
                if (node.equals(dst)) {

                    list.add(src);
                }
            }
            map.put(node, list);
        }
        return map;

    }
}
