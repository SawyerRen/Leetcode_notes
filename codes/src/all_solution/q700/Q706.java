package all_solution.q700;

public class Q706 {
}

class MyHashMap {
    ListNode[] list = new ListNode[10000];

    public MyHashMap() {

    }

    public void put(int key, int value) {
        int index = Integer.hashCode(key) % list.length;
        if (list[index] == null) {
            list[index] = new ListNode(-1, -1);
        }
        ListNode pre = findPre(list[index], key);
        if (pre.next == null) {
            pre.next = new ListNode(key, value);
        } else {
            pre.next.val = value;
        }
    }

    private ListNode findPre(ListNode head, int key) {
        ListNode pre = head;
        while (pre.next != null && pre.next.key != key) {
            pre = pre.next;
        }
        return pre;
    }

    public int get(int key) {
        int index = Integer.hashCode(key) % list.length;
        if (list[index] == null) return -1;
        ListNode pre = findPre(list[index], key);
        if (pre.next == null) return -1;
        return pre.next.val;
    }

    public void remove(int key) {
        int index = Integer.hashCode(key) % list.length;
        if (list[index] == null) return;
        ListNode pre = findPre(list[index], key);
        if (pre.next == null) return;
        pre.next = pre.next.next;
    }

    class ListNode {
        int key;
        int val;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}