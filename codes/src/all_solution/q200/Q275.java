package all_solution.q200;

public class Q275 {
    public int hIndex(int[] citations) {
        int left = 0, right = citations.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] < citations.length - mid) left = mid + 1;
            else right = mid - 1;
        }
        return citations.length - left;
    }
}
