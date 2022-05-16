package all_solution.q1800;

public class Q1832 {
    public boolean checkIfPangram(String sentence) {
        int[] count = new int[26];
        for (char c : sentence.toCharArray()) {
            count[c - 'a']++;
        }
        for (int val : count) {
            if (val == 0) return false;
        }
        return true;
    }
}
