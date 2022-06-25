package codetopbytedance0001to0050.codetop0026;

import struct.ListNode;

public class LeetCode021SolutionRecursive {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(null == list1) {
            return list2;
        }
        if(null == list2) {
            return list1;
        }

        if(list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

}
