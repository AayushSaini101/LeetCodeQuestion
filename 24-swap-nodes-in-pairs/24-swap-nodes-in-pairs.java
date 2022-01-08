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
  
    public List<ListNode> reverse(ListNode left,ListNode right){
        ListNode previous=null;
        
        ListNode next=null;
        
        ListNode head=null;
        
        ListNode last=left;
            
        while(left!=right){
            
            next=left.next;
            
            left.next=previous;
            
            previous=left;
            
            left=next;
        }
            next=left.next;
        
            left.next=previous;
        
            previous=left;
        
            left=next;
        
        head=previous;
       // print(head);
            
      List<ListNode>data=new ArrayList<>();
        
      data.add(head);
        
      data.add(last);
        
      return data;
        
        //we have to return the head and the lastNode of the reversed part
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
    
        int k=2;
        
        ListNode ref=head;
        
        ListNode left=head;
        
        ListNode right=head;
        
        int count=0;
        
        ListNode newhead=head;
        
        ListNode previous=null;
        
          ListNode temp=null;
        
        while(ref!=null){
            
            ++count;
            
            if(count==k){
                
             temp=ref.next;
                
                
               List<ListNode>data=reverse(left,ref);
                
               if(newhead==head){
                   //Now the new head is the front part of the list
                   newhead=data.get(0);
                   previous=data.get(1);
                 }
                else{
                    previous.next=data.get(0);
                    previous=data.get(1);
                    
                    
                }
                
                left=temp;
                
                ref=temp;
                
             count=0;   
            }
            else{
             ref=ref.next;   
            }
                
            
        }
        previous.next=temp;
        return newhead;
        
    }
}