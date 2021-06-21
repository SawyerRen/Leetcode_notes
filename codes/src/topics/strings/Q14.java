package topics.strings;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.
 */
public class Q14 {
    public String longestCommonPrefix(String[] strs) {
        int prefixLen = 0;
        if (strs.length == 0) return "";
        prefixLen = strs[0].length();
        for (String str : strs) {
            while (!str.startsWith(strs[0].substring(0, prefixLen))) {
                prefixLen--;
            }
        }
        return strs[0].substring(0, prefixLen);
    }
}
