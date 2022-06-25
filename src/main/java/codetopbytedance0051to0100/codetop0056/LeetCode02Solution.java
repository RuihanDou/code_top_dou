package codetopbytedance0051to0100.codetop0056;

import struct.ListNode;

public class LeetCode02Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry!=0 ) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            result.next = new ListNode(sum % 10);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            result = result.next;
        }
        return dummy.next;
    }

}
