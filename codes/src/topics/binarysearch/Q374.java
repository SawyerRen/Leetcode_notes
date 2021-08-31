package topics.binarysearch;

public class Q374 {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) return mid;
            if (guess(mid) == -1) right = mid - 1;
            else left = mid + 1;
        }
        return 0;
    }

    int guess(int num) {
        return 0;
    }
}
