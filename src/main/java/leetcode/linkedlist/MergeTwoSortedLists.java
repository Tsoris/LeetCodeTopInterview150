package leetcode.linkedlist;

public class MergeTwoSortedLists {

    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode currNode = null;

        if (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                currNode = list2;
                list2 = list2.next;
            } else {
                currNode = list1;
                list1 = list1.next;
            }
            head = currNode;
        }

        if (list1 == null) {
            if (currNode != null) {
                currNode.next = list2;
            } else {
                head = list2;
                return head;
            }
        } else if (list2 == null) {
            if (currNode != null) {
                currNode.next = list1;
            } else {
                head = list1;
                return head;
            }
        }

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                currNode.next = list2;
                list2 = list2.next;
            } else {
                currNode.next = list1;
                list1 = list1.next;
            }
            currNode = currNode.next;
        }

        if (list1 == null && list2 != null) {
            currNode.next = list2;
        } else if (list2 == null && list1 != null) {
            currNode.next = list1;
        }

        return head;
    }


    public ListNode cleanedMergeTwoList(ListNode list1, ListNode list2) {
        //handles null list logic cleanly to deal with happy path
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head;

        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        ListNode currNode = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currNode.next = list1;
                list1 = list1.next;
            } else {
                currNode.next = list2;
                list2 = list2.next;
            }

            currNode = currNode.next;
        }

        if (list1 != null) {
            currNode.next = list1;
        } else {
            currNode.next = list2;
        }

        return head;
    }

    public ListNode optimalMergeTwoList(ListNode list1, ListNode list2) {
        //sentinel solution, time complexity is the same as above, but the easiest to reason about
        ListNode sentinel = new ListNode();
        ListNode curr = sentinel;

        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }

        if (list1 == null) {
            curr.next = list2;
        } else {
            curr.next = list1;
        }

        return sentinel.next;
    }

}
