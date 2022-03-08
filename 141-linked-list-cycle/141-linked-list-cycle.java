/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }
     //Solve using the 
        if(head.next==null){
            return false;
        }
        ListNode fast=head;
        
        ListNode slow=head;
        
        while(fast!=null&&fast.next!=null&&fast.next.next!=null&&fast.next.next.next!=null){
              fast=fast.next.next.next.next;
              slow=slow.next.next;
              if(fast==slow){
            return true;
        }
        }
      
        return false;
    }
}