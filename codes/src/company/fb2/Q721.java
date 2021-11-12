package company.fb2;

import java.util.*;

public class Q721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (map.containsKey(mail)) {
                    int preIndex = map.get(mail);
                    uf.union(preIndex, i);
                } else {
                    map.put(mail, i);
                }
            }
        }
        Map<Integer, Set<String>> indexMailMap = new HashMap<>();
        for (String mail : map.keySet()) {
            int parentIndex = uf.find(map.get(mail));
            indexMailMap.putIfAbsent(parentIndex, new HashSet<>());
            indexMailMap.get(parentIndex).add(mail);
        }
        List<List<String>> res = new ArrayList<>();
        for (Integer index : indexMailMap.keySet()) {
            List<String> mails = new ArrayList<>(indexMailMap.get(index));
            Collections.sort(mails);
            mails.add(0, accounts.get(index).get(0));
            res.add(mails);
        }
        return res;
    }

    class UnionFind {
        int[] parents;

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        int find(int i) {
            while (i != parents[i]) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }

        void union(int i, int j) {
            int p1 = find(i), p2 = find(j);
            if (p1 == p2) return;
            parents[p2] = p1;
        }
    }
}
