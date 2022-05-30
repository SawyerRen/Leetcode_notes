package all_solution.q0;

import model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int left = 0, right = lists.length - 1;
        return helper(lists, left, right);
    }

    private ListNode helper(ListNode[] lists, int left, int right) {
        if (left > right) return null;
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = helper(lists, left, mid);
        ListNode l2 = helper(lists, mid + 1, right);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) cur.next = list1;
        if (list2 != null) cur.next = list2;
        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            if (head != null) pq.add(head);
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
