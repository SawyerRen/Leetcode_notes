package all_solution.q400;

import model.ListNode;

import java.util.Stack;

public class Q445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode();
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int v1 = s1.isEmpty() ? 0 : s1.pop();
            int v2 = s2.isEmpty() ? 0 : s2.pop();
            int sum = v1 + v2 + carry;
            ListNode next = new ListNode(sum % 10);
            next.next = dummy.next;
            dummy.next = next;
            carry = sum / 10;
        }
        return dummy.next;
    }
}
