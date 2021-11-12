package company.fb2;

import model.ListNode;

import java.util.PriorityQueue;

public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int left, int right) {
        if (left > right) return null;
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = helper(lists, left, mid);
        ListNode l2 = helper(lists, mid + 1, right);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            cur.next = poll;
            cur = cur.next;
            if (poll.next != null) pq.add(poll.next);
        }
        return dummy.next;
    }
}
