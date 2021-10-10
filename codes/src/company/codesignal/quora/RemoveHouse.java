package company.codesignal.quora;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveHouse {
    static int[] removeHouse(int[] houses, int[] queries) {
        int[] res = new int[queries.length];
        int count = 1;
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] > houses[i - 1] + 1) count++;
        }
        Set<Integer> set = new HashSet<>();
        for (int house : houses) {
            set.add(house);
        }
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            if (set.contains(query - 1) && set.contains(query + 1)) {
                res[i] = ++count;
            } else if (!set.contains(query - 1) && !set.contains(query + 1)) {
                res[i] = --count;
            } else {
                res[i] = count;
            }
            set.remove(query);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] houses = {1, 2, 3};
        int[] queries = {2, 1, 3};
        System.out.println(Arrays.toString(removeHouse(houses, queries)));
    }
}
