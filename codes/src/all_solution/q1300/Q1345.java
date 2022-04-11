package all_solution.q1300;

import java.util.*;

public class Q1345 {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        int res = 0;
        queue.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                if (poll == arr.length - 1) return res;
                if (poll + 1 < arr.length && !visited[poll + 1]) {
                    queue.add(poll + 1);
                    visited[poll + 1] = true;
                }
                if (poll - 1 >= 0 && !visited[poll - 1]) {
                    queue.add(poll - 1);
                    visited[poll - 1] = true;
                }
                if (map.containsKey(arr[poll])) {
                    for (Integer index : map.get(arr[poll])) {
                        if (visited[index]) continue;
                        queue.add(index);
                        visited[index] = true;
                    }
                    map.get(arr[poll]).clear();
                }
            }
            res++;
        }
        return -1;
    }
}
