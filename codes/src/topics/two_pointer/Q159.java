package topics.two_pointer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t 。

示例 1:

输入: "eceba"
输出: 3
解释: t 是 "ece"，长度为3。
示例 2:

输入: "ccaabbb"
输出: 5
解释: t 是 "aabbb"，长度为5。
 */
public class Q159 {
    public int lengthOfLongestSubstringTwoDistinct(String str) {
        int len = str.length();
        if (len <= 2) return len;
        int res = 2;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while (j < str.length()) {
            if (map.size() <= 2) {
                map.put(str.charAt(j), j);
                j++;
            }
            if (map.size() > 2) {
                int index = Collections.min(map.values());
                i = index + 1;
                map.remove(str.charAt(index));
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}
