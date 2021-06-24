package topics.two_pointer;

import java.util.LinkedList;

public class Q125 {
    public boolean isPalindrome(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) list.addLast(c);
            else if (Character.isLetter(c)) list.addLast(Character.toLowerCase(c));
        }
        return helper(list);
    }

    private boolean helper(LinkedList<Character> list) {
        while (list.size() > 1) {
            char left = list.removeFirst();
            char right = list.removeLast();
            if (left != right) return false;
        }
        return true;
    }
}
