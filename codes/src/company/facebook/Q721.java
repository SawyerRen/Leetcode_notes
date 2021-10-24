package company.facebook;

import java.util.*;

public class Q721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> mailIndexMap = new HashMap<>();
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (mailIndexMap.containsKey(mail)) {
                    int index = mailIndexMap.get(mail);
                    uf.union(index, i);
                } else {
                    mailIndexMap.put(mail, i);
                }
            }
        }
        Map<Integer, Set<String>> indexMailMap = new HashMap<>();
        for (String mail : mailIndexMap.keySet()) {
            int parentIndex = uf.find(mailIndexMap.get(mail));
            indexMailMap.putIfAbsent(parentIndex, new HashSet<>());
            indexMailMap.get(parentIndex).add(mail);
        }
        List<List<String>> res = new ArrayList<>();
        for (Integer index : indexMailMap.keySet()) {
            Set<String> mails = indexMailMap.get(index);
            List<String> list = new ArrayList<>(mails);
            Collections.sort(list);
            list.add(0, accounts.get(index).get(0));
            res.add(list);
        }
        return res;
    }

    class UnionFind {
        int[] parents;
        int[] size;
        int n;

        public UnionFind(int n) {
            this.n = n;
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        int find(int a) {
            while (a != parents[a]) {
                parents[a] = parents[parents[a]];
                a = parents[a];
            }
            return a;
        }

        void union(int i, int j) {
            int p1 = find(i);
            int p2 = find(j);
            if (p1 == p2) return;
            if (size[p1] > size[p2]) {
                parents[p2] = p1;
                size[p1] += size[p2];
            } else {
                parents[p1] = p2;
                size[p2] += p1;
            }
        }
    }
}
