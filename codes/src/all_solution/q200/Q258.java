package all_solution.q200;

public class Q258 {
    public int addDigits(int num) {
        if (num < 10) return num;
        int n = 0;
        while (num != 0) {
            int tail = num % 10;
            n += tail;
            num /= 10;
        }
        return addDigits(n);
    }
}
