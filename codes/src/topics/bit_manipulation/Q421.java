package topics.bit_manipulation;

public class Q421 {
    static class Trie {
        Trie[] children;

        public Trie() {
            this.children = new Trie[2];
        }
    }

    public int findMaximumXOR(int[] nums) {
        if (nums.length == 0) return 0;
        Trie root = new Trie();
        // 把每个数加入到二进制trie中
        for (int num : nums) {
            Trie cur = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (cur.children[bit] == null) cur.children[bit] = new Trie();
                cur = cur.children[bit];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int num : nums) {
            Trie cur = root;
            int sum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                // 如果bit=0，寻找1，如果bit=1，寻找0
                if (cur.children[bit ^ 1] != null) {
                    cur = cur.children[bit ^ 1];
                    sum += (1 << i);
                } else {
                    cur = cur.children[bit];
                }
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
