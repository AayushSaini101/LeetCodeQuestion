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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(0,head);
        
        ListNode temp=head;
        
        ListNode curr=dummy;
        
        boolean check=false;
        
        while(temp!=null){
            
            if(temp.next!=null){
                //Avoiding the same value nodes 
                while(temp!=null&&temp.next!=null&&temp.next.val==temp.val){
                      check=true;
                      temp=temp.next;
                }
                if(check==true){
                 curr.next=temp.next;
                 
                 temp=temp.next;
                 
                }
                else{
                   curr=temp;
                  
                   temp=temp.next;
                    
                }
                check=false;
                
            }
            else{
                break;
            }
        }
        return dummy.next;
    }
}