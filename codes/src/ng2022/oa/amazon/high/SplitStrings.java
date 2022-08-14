package ng2022.oa.amazon.high;

public class SplitStrings {
    static int solution(String s, int k) {
        int[] countS = new int[26];
        int[] temp = new int[26];
        for (char c : s.toCharArray()) {
            countS[c - 'a']++;
            temp[c - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            temp[s.charAt(i) - 'a']--;
            int count = getCount(countS, temp);
            if (count > k) res++;
        }
        return res;
    }

    private static int getCount(int[] countS, int[] temp) {
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (countS[i] > temp[i] && temp[i] > 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution("abbcac", 1));
    }
}
