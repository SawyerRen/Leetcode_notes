package all_solution.q300;

import java.util.Random;

public class Q384 {
}

class Solution {
    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] copy = nums.clone();
        for (int i = 1; i < copy.length; i++) {
            int index = random.nextInt(i + 1);
            int t = copy[i];
            copy[i] = copy[index];
            copy[index] = t;
        }
        return copy;
    }
}