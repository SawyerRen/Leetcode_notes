package company.bytedance.interview;

import java.util.Arrays;

public class Q16 {
    int[] findBestMoviePair(int[] movies, int duration) {
        Arrays.sort(movies);
        int i = 0, j = movies.length - 1;
        int left = -1, right = -1, max = 0;
        while (i < j) {
            if (movies[i] + movies[j] < duration) {
                if (movies[i] + movies[j] > max) {
                    max = movies[i] + movies[j];
                    left = i;
                    right = j;
                    i++;
                } else {
                    j--;
                }
            }
        }
        return new int[]{left, right};
    }
}
