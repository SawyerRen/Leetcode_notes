package company.fbfinal;

import java.util.*;

public class Q721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> mailIndexMap = new HashMap<>();
        UnionFind uf = new UnionFind(accounts.size());
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
        for (Integer index : indexMailMap.keySet()) {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(index).get(0));
            List<String> mails = new ArrayList<>(indexMailMap.get(index));
            Collections.sort(mails);
            list.addAll(mails);
            res.add(list);
        }
        return res;
    }

    class UnionFind {
        int[] parents;
        int size;

        public UnionFind(int size) {
            this.size = size;
            parents = new int[size];
            for (int i = 0; i < size; i++) {
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
            size--;
        }
    }
}
