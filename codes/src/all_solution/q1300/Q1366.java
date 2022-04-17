package all_solution.q1300;

import java.util.*;

public class Q1366 {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[26]);
                map.get(c)[i]++;
            }
        }
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> {
            int[] list1 = map.get(a);
            int[] list2 = map.get(b);
            for (int i = 0; i < list1.length; i++) {
                if (list1[i] != list2[i]) return list2[i] - list1[i];
            }
            return a - b;
        });
        StringBuilder builder = new StringBuilder();
        for (Character c : list) {
            builder.append(c);
        }
        return builder.toString();
    }
}
