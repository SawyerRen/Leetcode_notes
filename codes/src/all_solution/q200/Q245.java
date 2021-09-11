package all_solution.q200;

public class Q245 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        Integer index1 = null, index2 = null;
        boolean same = word1.endsWith(word2);
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                if (same) {
                    index2 = index1;
                }
                index1 = i;
            } else if (wordsDict[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != null && index2 != null) {
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        return res;
    }
}
