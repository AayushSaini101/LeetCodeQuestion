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
    public ListNode partition(ListNode head, int x) {
        
        ListNode first=null;
        ListNode second=null;
        ListNode secondhead=null;
        
        ListNode temp=head;
        
        ListNode answer=null;
        
        while(temp!=null){
            
            if(temp.val<x){
                
                if(first==null){
                    first=new ListNode(temp.val);
                    answer=first;
                }
                else{
                    first.next=new ListNode(temp.val);
                    
                    first=first.next;
                }
            }
            else{
                
                if(second==null){
                    
                    second=new ListNode(temp.val);
                    
                    secondhead=second;
                }
                else{
                    second.next=new ListNode(temp.val);
                    
                    second=second.next;
                }
            }
            
            temp=temp.next;
        }
        
        if(answer==null){
            return secondhead;
        }
        else{
            first.next=secondhead;
            
            return answer;
        }
        
        
    }
}