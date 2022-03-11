/**
 * Definition for singly-linked list.
 * public class ListListListNode {
 *     int val;
 *     ListListNode next;
 *     ListListNode() {}
 *     ListListNode(int val) { this.val = val; }
 *     ListListNode(int val, ListListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //Reversing the subpart
    public ListNode Reverse(ListNode head,ListNode last){
        ListNode tempHead=head;
        ListNode previous=null;
        ListNode next=null;
        
        while(tempHead!=last){
            next=tempHead.next;
            tempHead.next=previous;
            previous=tempHead;
            tempHead=next;
        }
        //Revering the last ListNode also 
        if(last!=null){
            next=tempHead.next;
            tempHead.next=previous;
            previous=tempHead;
            tempHead=next;
            
        }
        
        return previous;
        
    
    }
    public void print(ListNode head){
        while(head!=null){
            System.out.print(head.val);
            head=head.next;
        }
    }
    public int length(ListNode head){
        ListNode tempHead=head;
        int count=0;
        while(tempHead!=null){
            ++count;
            tempHead=tempHead.next;
        }
        return count;
    }
    public void join(ListNode first,ListNode second){
        ListNode tempFirst=first;
        while(tempFirst.next!=null){
            tempFirst=tempFirst.next;
        }
        tempFirst.next=second;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        ListNode tempHead=head;
        ListNode firstHalf=head;
        ListNode tailFirstHalf=head;
        int length=length(head);
        k=k%length;
        if(k==0){
            return head;
        }
        for(int i=1;i<length-k;++i){
            tempHead=tempHead.next;
        }
        
      
    
        ListNode second=Reverse(tempHead.next,null);
        ListNode first=(Reverse(firstHalf,tempHead));
        
        join(first,second);
      
      return  Reverse(first,null);
       // return first;
      
        
        
    }
}