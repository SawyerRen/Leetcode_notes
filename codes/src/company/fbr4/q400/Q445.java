package company.fbr4.q400;

import model.ListNode;

import java.util.Stack;

public class Q445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        Stack<Integer> resStack = new Stack<>();
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int n1 = stack1.isEmpty() ? 0 : stack1.pop();
            int n2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = n1 + n2 + carry;
            resStack.push(sum % 10);
            carry = sum / 10;
        }
        while (!resStack.isEmpty()) {
            cur.next = new ListNode(resStack.pop());
            cur = cur.next;
        }
        return dummy.next;
    }
}
