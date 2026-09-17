package leetcode.linkedlist;

public class RemoveNthNodeFromEndOfList {
    public ListNode twoPassRemoveNthFromEnd(ListNode head, int n) {
        ListNode curr = head;

        int size = 1;

        while (curr.next != null) {
            curr = curr.next;
            size++;
        }

        curr = head;

        for (int i = 1; i < size - n; i++) {
            curr = curr.next;
        }

        if (n == size) {
            head = head.next;
        } else {
            curr.next = curr.next.next;
        }
        return head;
    }

    public ListNode singlePassRemoveNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;

        ListNode curr = sentinel;
        ListNode nthAhead = sentinel;

        for (int i = 0; i < n + 1; i++) {
            nthAhead = nthAhead.next;
        }

        while (nthAhead != null) {
            curr = curr.next;
            nthAhead = nthAhead.next;
        }

        curr.next = curr.next.next;


        return sentinel.next;
    }
}
