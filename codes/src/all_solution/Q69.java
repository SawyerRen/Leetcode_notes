package all_solution;

public class Q69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int left = 1, right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 找到平方大于x的最小值
            if (x / mid < mid) right = mid;
            else left = mid + 1;
        }
        return left - 1;
    }
}
