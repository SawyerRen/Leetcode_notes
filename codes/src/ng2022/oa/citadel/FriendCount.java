package ng2022.oa.citadel;

import java.util.Arrays;

public class FriendCount {
    public static int[] friendCount(int n, String[] queryType, int[] student1, int[] student2) {
        int[] parents = new int[n + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        int[] size = new int[n + 1];
        Arrays.fill(size, 1);
        int[] res = new int[queryType.length];
        for (int i = 0; i < queryType.length; i++) {
            if (queryType[i].equals("Friend")) {
                union(parents, size, student1[i], student2[i]);
                res[i] = 0;
            } else if (queryType[i].equals("Total")) {
                int p1 = root(parents, student1[i]);
                int p2 = root(parents, student2[i]);
                if (p1 == p2) res[i] = size[p1];
                else res[i] = size[p1] + size[p2];
            }
        }
        return res;
    }

    private static void union(int[] parents, int[] size, int i, int j) {
        int p1 = root(parents, i);
        int p2 = root(parents, j);
        if (p1 == p2) return;
        if (size[p1] > size[p2]) {
            parents[p2] = p1;
            size[p1] += size[p2];
        } else {
            parents[p1] = p2;
            size[p2] += size[p1];
        }
    }

    private static int root(int[] parents, int i) {
        while (i != parents[i]) {
            parents[i] = parents[parents[i]];
            i = parents[i];
        }
        return i;
    }

    public static void main(String[] args) {
        String[] queryType = {"Friend", "Friend", "Total"};
        int[] s1 = {1, 2, 1};
        int[] s2 = {2, 3, 3};
        int[] res = friendCount(4, queryType, s1, s2);
        for (int re : res) {
            System.out.println(re);
        }
    }
}
