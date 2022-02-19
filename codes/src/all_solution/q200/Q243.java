package all_solution.q200;

public class Q243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        Integer index1 = null, index2 = null;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (word1.equals(wordsDict[i])) {
                index1 = i;
            } else if (word2.equals(wordsDict[i])) {
                index2 = i;
            }
            if (index1 != null && index2 != null) {
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        return res;
    }
}
