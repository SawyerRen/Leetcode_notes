package company.bytedance.oa2022;

import java.util.*;

//import javafx.*;

public class MinimumJumps {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
//        int steps = 0, furthest = x + a + b;
//        Queue<Pair<Integer, Integer>> q = new LinkedList();
//        q.offer(new Pair(0, 0)); // direction & position;
//        Set<Pair<Integer, Integer>> seen = new HashSet<>(q);
//        for (int pos : forbidden) {
//            seen.add(new Pair(0, pos));
//            seen.add(new Pair(1, pos));
//            furthest = Math.max(furthest, pos + a + b);
//        }
//        while (!q.isEmpty()) {
//            for (int sz = q.size(); sz > 0; --sz) {
//                Pair<Integer, Integer> p = q.poll();
//                int dir = p.getKey(), pos = p.getValue();
//                if (pos == x) {
//                    return steps;
//                }
//                Pair<Integer, Integer> forward = new Pair<>(0, pos + a), backward = new Pair<>(1, pos - b);
//                if (pos + a <= furthest && seen.add(forward)) {
//                    q.offer(forward);
//                }
//                if (dir == 0 && pos - b >= 0 && seen.add(backward)) {
//                    q.offer(backward);
//                }
//            }
//            ++steps;
//        }
        return -1;
    }

    Set<Integer> bad = new HashSet<>();
    Set<String> set = new HashSet<>();

    public int minimumJumps1(int[] A, int a, int b, int x) {
        for (int i : A) {
            bad.add(i);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        set.add("0,0");
        while (q.size() != 0) {
            int pair[] = q.poll();

            int pos = pair[0], level = pair[1], state = pair[2];
            if (pos == x) return level;

            if (state >= 0) {
                if (pos <= 10000 && !set.contains((pos + a) + ",0") && !bad.contains(pos + a)) {
                    set.add((pos + a) + ",0");
                    q.add(new int[]{pos + a, level + 1, 0});
                }

                if (!set.contains((pos - b) + ",-1") && !bad.contains(pos - b) && pos - b >= 0) {
                    set.add((pos - b) + ",-1");
                    q.add(new int[]{pos - b, level + 1, -1});
                }
            } else if (state < 0) {
                if (pos <= 10000 && !set.contains((pos + a) + ",0") && !bad.contains(pos + a)) {
                    set.add((pos + a) + ",0");
                    q.add(new int[]{pos + a, level + 1, 0});
                }

            }
        }
        return -1;
    }
}
