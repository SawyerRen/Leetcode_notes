package company.fbr5.q1000;

public class Q1053 {
    public int[] prevPermOpt1(int[] arr) {
        int k = arr.length - 2;
        while (k >= 0 && arr[k] <= arr[k + 1]) {
            k--;
        }
        if (k < 0) return arr;
        for (int i = arr.length - 1; i > k; i--) {
            if (arr[i] < arr[k] && arr[i] != arr[i - 1]) {
                int t = arr[i];
                arr[i] = arr[k];
                arr[k] = t;
                return arr;
            }
        }
        return arr;
    }
}
