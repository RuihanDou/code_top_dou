package codetopbytedance0001to0050.codetop0017;

import struct.ListNode;

import java.util.PriorityQueue;

public class LeetCode023Solution {

    private class Status implements Comparable<Status>{
        int val;
        ListNode p;

        public Status(int val, ListNode p){
            this.val = val;
            this.p = p;
        }

        @Override
        public int compareTo(Status status2){
            return this.val - status2.val;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Status> queue = new PriorityQueue<>();
        for(ListNode node : lists){
            if(node != null){
                queue.offer(new Status(node.val, node));
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!queue.isEmpty()){
            Status s = queue.poll();
            tail.next = s.p;
            tail = tail.next;
            if(s.p.next != null){
                queue.offer(new Status(s.p.next.val, s.p.next));
            }
        }
        return dummy.next;
    }

}
