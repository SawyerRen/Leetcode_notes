package all_solution.q300;

public class Q243 {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int res = wordsDict.length;
        Integer index1 = null, index2 = null;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                index1 = i;
            } else if (wordsDict[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != null && index2 != null) {
                res = Math.min(Math.abs(index1 - index2), res);
            }
        }
        return res;
    }
}
