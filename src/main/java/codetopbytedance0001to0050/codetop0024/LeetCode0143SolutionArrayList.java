package codetopbytedance0001to0050.codetop0024;

import struct.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode0143SolutionArrayList {

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0,  j = list.size() - 1;
        while (i < j){
            list.get(i).next = list.get(j);
            i++;
            if(i == j){
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
