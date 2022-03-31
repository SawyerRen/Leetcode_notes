package all_solution.q1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q1268 {
    class Trie {
        Trie[] children = new Trie[26];
        List<String> suggestion = new ArrayList<>();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        Trie root = new Trie();
        for (String product : products) {
            Trie cur = root;
            for (char c : product.toCharArray()) {
                if (cur.children[c - 'a'] == null) cur.children[c - 'a'] = new Trie();
                cur = cur.children[c - 'a'];
                if (cur.suggestion.size() < 3) cur.suggestion.add(product);
            }
        }
        Trie cur = root;
        for (char c : searchWord.toCharArray()) {
            if (cur.children[c - 'a'] == null) break;
            cur = cur.children[c - 'a'];
            res.add(cur.suggestion);
        }
        while (res.size() < searchWord.length()) res.add(new ArrayList<>());
        return res;
    }
}
