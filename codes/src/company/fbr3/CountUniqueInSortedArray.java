package company.fbr3;

public class CountUniqueInSortedArray {
    static int unique(int[] a) {
        int i = 0;
        int count = 0;
        while (i < a.length) {
            i = nextIndex(a, i, a[i] + 1);
            count++;
        }
        return count;
    }

    static int nextIndex(int[] a, int left, int target) {
        int right = a.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (a[mid] >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 2, 2, 5, 5, 5, 7, 7, 8, 8, 10};
        System.out.println(unique(nums));
    }
}
