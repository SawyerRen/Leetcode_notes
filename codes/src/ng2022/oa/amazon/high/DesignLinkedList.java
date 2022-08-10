package ng2022.oa.amazon.high;

public class DesignLinkedList {
    class SinglyLinkedListNode {
        String itemName;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode() {
        }

        public SinglyLinkedListNode(String itemName, SinglyLinkedListNode next) {
            this.itemName = itemName;
            this.next = next;
        }
    }

    SinglyLinkedListNode getShoppingCart(SinglyLinkedListNode head, String[][] operations) {
        for (String[] operation : operations) {
            switch (operation[0]) {
                case "PUSH_HEAD":
                    head = new SinglyLinkedListNode(operation[1], head);
                case "PUSH_TAIL":
                    SinglyLinkedListNode cur = head;
                    while (cur.next != null) cur = cur.next;
                    cur.next = new SinglyLinkedListNode(operation[1], null);
                case "POP_HEAD":
                    head = head.next;
            }
        }
        return head;
    }

}
