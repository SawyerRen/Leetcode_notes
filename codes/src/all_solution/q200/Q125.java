package all_solution.q200;

public class Q125 {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(s.charAt(left)) && !Character.isDigit(s1.charAt(left))) left++;
            while (left < right && !Character.isLetter(s.charAt(right)) && !Character.isDigit(s1.charAt(right))) right--;
            if (left < right && s1.charAt(left) != s1.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
