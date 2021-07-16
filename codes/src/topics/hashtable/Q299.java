package topics.hashtable;

public class Q299 {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] count1 = new int[10];
        int[] count2 = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int char1 = secret.charAt(i);
            int char2 = guess.charAt(i);
            if (char1 == char2) {
                bulls++;
            } else {
                count1[char1 - '0']++;
                count2[char2 - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(count1[i], count2[i]);
        }
        return bulls + "A" + cows + 'B';
    }
}
