package company.fbr5.q400;

import model.ListNode;

import java.util.Stack;

public class Q445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>(), stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode dummy = new ListNode();
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int n1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int n2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            int sum = n1 + n2 + carry;
            ListNode cur = new ListNode(sum % 10);
            cur.next = dummy.next;
            dummy.next = cur;
            carry = sum / 10;
        }
        return dummy.next;
    }
}
