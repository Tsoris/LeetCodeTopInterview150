package leetcode.linkedlist;

public class ReorderList {
    public void reorderList(ListNode head) {
        ListNode curr = head;

        int count = 1;

        while (curr != null) {
            curr = curr.next;
            count ++;
        }

        curr = head;

        for (int i = 1; i < count/2; i++) {
            curr = curr.next;
        }

        ListNode endHalf = curr.next;
        curr.next = null;

        ListNode prev = null;
        ListNode currEndHalf = endHalf;
        ListNode endHalfHead = null;
        while (currEndHalf != null) {
            if (currEndHalf.next == null) {
                endHalfHead = currEndHalf;
            }
            ListNode currNext = currEndHalf.next;
            currEndHalf.next = prev;
            prev = currEndHalf;
            currEndHalf = currNext;
        }

        ListNode frontHalfHead = head.next;
        ListNode mergedList = head;
        while (endHalfHead != null && frontHalfHead != null) {
            mergedList.next = endHalfHead;

            endHalfHead = endHalfHead.next;

            mergedList = mergedList.next;

            mergedList.next = frontHalfHead;

            frontHalfHead = frontHalfHead.next;

            mergedList = mergedList.next;
        }

        if (frontHalfHead != null) {
            mergedList.next = frontHalfHead;
        }
        if (endHalfHead != null) {
            mergedList.next = endHalfHead;
        }

    }
}
