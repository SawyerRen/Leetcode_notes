package topics.strings;

import java.util.Map;

/*
Given two strings s and t, determine if they are both one edit distance apart.

Note:

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.
 */
public class Q161 {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        int diff = m - n;
        if (Math.abs(diff) > 1) return false;
        if (diff == 1) {
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != t.charAt(i)) return s.substring(i + 1).equals(t.substring(i));
            }
            return true;
        }
        if (diff == -1) {
            for (int i = 0; i < m; i++) {
                if (s.charAt(i) != t.charAt(i)) return s.substring(i).equals(t.substring(i + 1));
            }
            return true;
        }
        if (diff == 0) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (s.charAt(i) != t.charAt(i)) count++;
            }
            return count <= 1;
        }
        return false;
    }
}
