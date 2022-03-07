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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //Merge Two Sorted List 
         List<Integer>lst=new ArrayList<>();
         while(list1!=null){
             lst.add(list1.val);
             list1=list1.next;
         }
        while(list2!=null){
            lst.add(list2.val);
            list2=list2.next;
        }
        Collections.sort(lst);
        
        ListNode answer=null;
        ListNode answerReference=answer;
        
      for(int elements:lst){
          if(answer==null){
              answer=new ListNode(elements);
              answerReference=answer;
          }
          else{
              answerReference.next=new ListNode(elements);
              answerReference=answerReference.next;
          }
      }
        return answer;
        
    }
}