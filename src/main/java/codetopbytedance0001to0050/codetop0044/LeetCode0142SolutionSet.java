package codetopbytedance0001to0050.codetop0044;

import struct.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode0142SolutionSet {

    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

}
