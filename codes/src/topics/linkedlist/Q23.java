package topics.linkedlist;

import model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeFrom(lists, 0, lists.length - 1);
    }

    private ListNode mergeFrom(ListNode[] lists, int left, int right) {
        if (left > right) return null;
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode list1 = mergeFrom(lists, left, mid);
        ListNode list2 = mergeFrom(lists, mid + 1, right);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) cur.next = head1;
        if (head2 != null) cur.next = head2;
        return dummy.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        // 优先队列（最小堆）
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        // 将每个链表头加入堆
        for (ListNode head : lists) {
            if (head != null) pq.add(head);
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            // 取出最小值，加入next节点
            ListNode poll = pq.poll();
            if (poll.next != null) pq.add(poll.next);
            cur.next = poll;
            cur = cur.next;
        }
        return dummy.next;
    }
}
