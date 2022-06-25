package codetopbytedance0001to0050.codetop0010;

import struct.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode0160SolutionHashSet {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode pointer = headA;
        while (pointer != null){
            set.add(pointer);
            pointer = pointer.next;
        }
        pointer = headB;
        while (pointer != null){
            if(set.contains(pointer)){
                return pointer;
            }
            pointer = pointer.next;
        }
        return null;
    }

}
