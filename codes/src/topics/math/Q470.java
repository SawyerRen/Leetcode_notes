package topics.math;

public abstract class Q470 {
    public int rand10() {
        int res = 49;
        while (res >= 40) res = 7 * (rand7() - 1) + (rand7() - 1); //[0,48]
        // [0,39]
        return res % 10 + 1;
    }

    public abstract int rand7();
}
