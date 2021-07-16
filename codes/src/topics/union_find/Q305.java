package topics.union_find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q305 {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[] parents;
    int[] size;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        parents = new int[m * n];
        Arrays.fill(parents, -1);
        size = new int[m * n];
        int count = 0;
        for (int[] position : positions) {
            int index = position[0] * n + position[1];
            if (parents[index] != -1) {
                res.add(count);
                continue;
            }
            parents[index] = index;
            size[index] = 1;
            count++;
            for (int[] dir : dirs) {
                int x = position[0] + dir[0], y = position[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                int neighbor = x * n + y;
                if (parents[neighbor] != -1) {
                    union(index, neighbor);
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    boolean find(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int i) {
        while (i != parents[i]) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int rp = root(p);
        int rq = root(q);
        if (rp == rq) return;
        if (size[rp] > size[rq]) {
            parents[rq] = rp;
            size[rp] += size[rq];
        } else {
            parents[rp] = rq;
            size[rq] += size[rp];
        }
    }
}
