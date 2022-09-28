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
    
    private boolean check=false;
    
    public int remove(ListNode node,int length){
    
        if(node==null)return 0;
        
        int countNodes=remove(node.next,length)+1;
        
        if(countNodes==length+1){
            //Deleting the node
           node.next=node.next.next;
            
           check=true;
        }
     
        return countNodes;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        
       remove(head,n);
        
       if(check==false){
           
           return head=head.next;
       }
        return head;
        
    }
}