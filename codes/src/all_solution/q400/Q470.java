package all_solution.q400;

import java.util.Random;

public class Q470 {
    public int rand10() {
        while (true) {
            int num = 7 * (rand7() - 1) + (rand7() - 1);
            if (num < 40) {
                int res = num % 10;
                if (res == 0) return 10;
                else return res;
            }
        }
    }

    public int rand7() {
        return new Random().nextInt(7) + 1;
    }
}
