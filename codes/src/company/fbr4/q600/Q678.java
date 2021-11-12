package company.fbr4.q600;

public class Q678 {
    public boolean checkValidString(String s) {
        int minOpen = 0, maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else if (c == '*') {
                minOpen--;
                maxOpen++;
            }
            if (maxOpen < 0) return false;
            minOpen = Math.max(0, minOpen);
        }
        return minOpen == 0;
    }
}
