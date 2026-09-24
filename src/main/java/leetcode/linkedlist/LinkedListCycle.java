package leetcode.linkedlist;

public class LinkedListCycle {
    // Time: O(n); Auxiliary space: O(1).
    // n = distinct reachable nodes including any cycle; fast and slow pointers.
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
