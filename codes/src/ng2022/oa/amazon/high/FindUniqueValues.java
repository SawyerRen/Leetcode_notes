package ng2022.oa.amazon.high;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class FindUniqueValues {
    static int findUniqueValues1(int[] experiences) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int experience : experiences) {
            map.put(experience, map.getOrDefault(experience, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        while (!map.isEmpty()) {
            int min = map.firstKey();
            int max = map.lastKey();
            set.add(min + max);
            map.put(min, map.get(min) - 1);
            if (map.get(min) == 0) map.remove(min);
            map.put(max, map.get(max) - 1);
            if (map.get(max) == 0) map.remove(max);
        }
        return set.size();
    }

    static int findUniqueValues(int[] experiences) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(experiences);
        int i = 0, j = experiences.length - 1;
        while (i < j) {
            set.add(experiences[i++] + experiences[j--]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] values = {1, 4, 1, 3, 5, 6};
        System.out.println(findUniqueValues1(values));
    }
}
