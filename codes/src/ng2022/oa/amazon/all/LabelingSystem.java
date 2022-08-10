package ng2022.oa.amazon.all;

public class LabelingSystem {
    public static String getLargestString(String origin, int k) {
        int[] board = new int[26];
        for (char c : origin.toCharArray()) {
            board[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int index = 25;
        int lastCount = 0;
        while (index >= 0) {
            if (board[index] == 0) {
                index--;
                lastCount = 0;
                continue;
            }
            if (lastCount < k) {
                sb.append((char) ('a' + index));
                lastCount++;
                board[index]--;
            } else {
                for (int i = index - 1; i >= 0; i--) {
                    if (board[i] > 0) {
                        sb.append((char) ('a' + i));
                        board[i]--;
                        lastCount = 0;
                        break;
                    }
                }
                if (lastCount != 0) {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
