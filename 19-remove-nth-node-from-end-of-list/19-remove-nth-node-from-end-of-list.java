/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    
    public int remove(ListNode node,ListNode head,int length){
    
        if(node==null)return 0;
        
        int countNodes=remove(node.next,head,length)+1;
        
        if(countNodes==length+1){
            //Deleting the node
           node.next=node.next.next;
        
        }
        else
            if(node==head&&countNodes==length)return -1;
     
        return countNodes;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        
      if(remove(head,head,n)==-1){
          
          return head=head.next;
      }
        
        return head;
        
    }
}