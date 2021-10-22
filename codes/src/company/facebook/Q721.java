package company.facebook;

import java.util.*;

public class Q721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> mailIndexMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (mailIndexMap.containsKey(mail)) {
                    Integer preIndex = mailIndexMap.get(mail);
                    uf.union(preIndex, i);
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
            List<String> mails = new ArrayList<>(indexMailMap.get(index));
            Collections.sort(mails);
            mails.add(0, accounts.get(index).get(0));
            res.add(mails);
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

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) return;
            if (size[pa] > size[pb]) {
                parents[pb] = pa;
                size[pa] += size[pb];
            } else {
                parents[pa] = pb;
                size[pb] += size[pa];
            }
        }

        int find(int a) {
            while (a != parents[a]) {
                parents[a] = parents[parents[a]];
                a = parents[a];
            }
            return a;
        }
    }
}
