package company.fbr5.q1200;

public class Q1265 {
    private interface ImmutableListNode {
        public void printValue(); // print the value of this node.

        public ImmutableListNode getNext(); // return the next node.
    }

    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) return;
        if (head.getNext() != null) {
            printLinkedListInReverse(head.getNext());
        }
        head.printValue();
    }
}
