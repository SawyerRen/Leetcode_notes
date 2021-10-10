package company.facebook;

import java.util.*;

public class Q721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        Map<String, Integer> mailIndexMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (mailIndexMap.containsKey(mail)) {
                    int preIndex = mailIndexMap.get(mail);
                    uf.union(i, preIndex);
                } else {
                    mailIndexMap.put(mail, i);
                }
            }
        }
        Map<Integer, Set<String>> indexMailMap = new HashMap<>();
        for (String mail : mailIndexMap.keySet()) {
            Integer index = mailIndexMap.get(mail);
            int parentIndex = uf.find(index);
            Set<String> mailSet = indexMailMap.getOrDefault(parentIndex, new HashSet<>());
            mailSet.add(mail);
            indexMailMap.put(parentIndex, mailSet);
        }
        List<List<String>> res = new ArrayList<>();
        for (Integer index : indexMailMap.keySet()) {
            ArrayList<String> mails = new ArrayList<>(indexMailMap.get(index));
            Collections.sort(mails);
            mails.add(0, accounts.get(index).get(0));
            res.add(mails);
        }
        return res;
    }

    class UnionFind {
        int[] parents;
        int[] size;
        int len;

        public UnionFind(int len) {
            this.len = len;
            this.parents = new int[len];
            this.size = new int[len];
            for (int i = 0; i < len; i++) {
                parents[i] = i;
                size[i] = 1;
            }
        }

        public int find(int a) {
            while (a != parents[a]) {
                parents[a] = parents[parents[a]];
                a = parents[a];
            }
            return a;
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (size[pa] < size[pb]) {
                parents[pb] = pa;
                size[pa] += size[pb];
            } else {
                parents[pa] = pb;
                size[pb] += size[pa];
            }
        }
    }
}
