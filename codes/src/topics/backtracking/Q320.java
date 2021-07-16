package topics.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Q320 {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, word, 0, 0, "");
        return res;
    }

    private void helper(List<String> res, String word, int index, int count, String cur) {
        if (index == word.length()) {
            if (count != 0) cur += count;
            res.add(cur);
            return;
        }
        // 两个选择：缩写当前字符或者不缩写
        // 缩写当前字符
        helper(res, word, index + 1, count + 1, cur);
        // 不缩写当前字符
        // 先加上之前的缩写的count
        if (count != 0) cur += count;
        cur += word.charAt(index);
        helper(res, word, index + 1, 0, cur);
    }
}
