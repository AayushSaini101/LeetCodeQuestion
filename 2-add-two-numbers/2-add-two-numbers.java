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
    public ListNode reverse(ListNode list){
        ListNode current=list;
        ListNode previous=null;
        ListNode next;
        while(current!=null){
            //Move the reference of the head
            next=current.next;
            //Shift the reference of the head to previous;
            current.next=previous;
            current=next;
        }
        //Returning the reverse linked list
        return previous;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode ans=null;
       ListNode ref=ans;
        
       int carry=0;
        
       int extraCarry=-1;
       
       while(l1!=null&&l2!=null){
           
           int value=l1.val+l2.val+carry;
           
           carry=value/10;
           
           int sum=value%10;
           
           if(ref==null){
               ans=new ListNode(sum);
               ref=ans;
           }
           else{
               ref.next=new ListNode(sum);
               ref=ref.next;
           }
           if(value>=10){
               extraCarry=carry;
           }
           else{
                extraCarry=-1;
            }
           
           l1=l1.next;
           l2=l2.next;
       }
        
        
        while(l1!=null){
            int value=l1.val+carry;
            
             int sum=value%10;
            
             carry=value/10;
            
              if(ref==null){
               ans=new ListNode(sum);
               ref=ans;
           }
           else{
               ref.next=new ListNode(sum);
               ref=ref.next;
           }
             if(value>=10){
               extraCarry=carry;
           }
            else{
                extraCarry=-1;
            }
           
            
            l1=l1.next;
            
        }
        
        while(l2!=null){
               int value=l2.val+carry;
            
             int sum=value%10;
            
             carry=value/10;
            
              if(ref==null){
               ans=new ListNode(sum);
               ref=ans;
           }
           else{
               ref.next=new ListNode(sum);
               ref=ref.next;
           }
             if(value>=10){
               extraCarry=carry;
           }
            else{
                extraCarry=-1;
            }
            l2=l2.next;
            
        }
        if(extraCarry!=-1){
            ref.next=new ListNode(extraCarry);
        }
      
        return ans;
       
        
    }
}