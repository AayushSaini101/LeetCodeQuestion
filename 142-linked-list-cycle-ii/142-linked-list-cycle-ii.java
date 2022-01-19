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
    public ListNode detectCycle(ListNode head) {
       HashSet<ListNode>H=new HashSet<>();
        
       while(head!=null){
           if(H.contains(head)){
               return head;
           }
           H.add(head);
           head=head.next;
       }
        return head;
    }
}