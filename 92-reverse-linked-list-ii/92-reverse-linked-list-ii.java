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
    
    public void print(ListNode head){
        
        ListNode temp=head;
        
        while(temp!=null){
            System.out.print(temp.val);
            temp=temp.next;
        }
    }
 
    public ListNode reverse(ListNode previousFirst,ListNode first,ListNode second,ListNode nextSecond){
        
        ListNode previous=null;
    
        ListNode next=null;
        
        ListNode head1=first;
        
        ListNode temp=null;
        
        while(first!=second){
            
            next=first.next;
            
            first.next=previous;
            
            previous=first;
            
            first=next;
            
        }
        
            next=first.next;
            
            first.next=previous;
            
            previous=first;
            
            first=next;
        
           return previous;
      
    }
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if(left==right){
            
            return head;
        }
        
        ListNode temp=head;
        
        ListNode first=null;
        
        ListNode second=null;
        
        ListNode previousFirst=null;
        
        ListNode nextSecond=null;
        
        int length=0;
        
        while(temp!=null){
        
            ++length;
            
            if(length==left-1){
                
                previousFirst=temp;
            }
            else
                
            if(length==left){
                
                first=temp;
            }
            else
                if(length==right){
                    
                    second=temp;
                }
            else
                if(length==right+1){
                    
                    nextSecond=temp;
                }
    
            
            temp=temp.next;
        }
        
        ListNode answer=reverse(previousFirst,first,second,nextSecond);
        
      //  print(answer);
        
        if(previousFirst==null&&nextSecond==null){
            return answer;
        }
        else
            if(previousFirst==null){
                head.next=nextSecond;
                return answer;
            }
       else
           if(nextSecond==null){
               
               previousFirst.next=answer;
               
               return head;
               
           }
        else{
            previousFirst.next=answer;
            first.next=nextSecond;
            
            return head;
        }
    
    }
}