package all_solution.q700;

public class Q744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) right = mid;
            else left = mid + 1;
        }
        if (left == letters.length) return letters[0];
        return letters[left];
    }
}
