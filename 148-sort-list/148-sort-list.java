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
    static ListNode middle(ListNode head){
    if(head==null){
        return head;
    }
    ListNode slow=head;
    ListNode fast=head;
    
    while(fast.next!=null&&fast.next.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    return slow;
}
static ListNode mergesort(ListNode head){
    if(head==null||head.next==null){
        return head;
    }
   
    ListNode middle=middle(head);
    ListNode first=head;
    ListNode second=middle.next;
    middle.next=null;
    ListNode first1=mergesort(first);
    ListNode second1=mergesort(second);
   ListNode and=sort(first1,second1);
   return and;
}
static ListNode sort(ListNode first,ListNode second){
ListNode head=null;
ListNode temp=head;
if(second==null){
    return first;
}
if(first==null){
    return second;
}
while(first!=null&&second!=null){
      if(first.val<second.val){
          if(head==null){
              head=first;
              temp=head;
          }
          else{
              temp.next=new ListNode(first.val);
              temp=temp.next;

          }
          first=first.next;
      }
      else{
        if(head==null){
            head=second;
            temp=head;
        }
        else{
            temp.next=new ListNode(second.val);
            temp=temp.next;

        }
        second=second.next;

      }
      
}
if(first!=null){
    temp.next=first;
}
if(second!=null){
    temp.next=second;
}
return head;


}
    public ListNode sortList(ListNode head) {
        head=mergesort(head);
        return head;
        
    }
}