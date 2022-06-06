/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int length(ListNode list){
        ListNode temp_head=list;
        int count=0;
        
        while(temp_head!=null){
            temp_head=temp_head.next;
            ++count;
        }
        return count;
    }
    public ListNode move(ListNode list,int time){
        
        while(list!=null&&time-->0){
            list=list.next;
            
        }
        return list;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     
        int lengthFirst=length(headA);
        int lengthSecond=length(headB);
         
        int diff=0;
        
        if(lengthFirst>lengthSecond){
        
            diff=lengthFirst-lengthSecond;
            
            //Move the head of the linked list 
           headA= move(headA,diff);
            
            
            
        }
        else
            if(lengthFirst<lengthSecond){
                
                diff=lengthSecond-lengthFirst;
                
                //Move the head of the lined list 
                headB=move(headB,diff);
                
              //  System.out.println(headB.val);
            }
     
    
        while(headA!=null&&headB!=null){
           // System.out.println(headA.val+" "+headB.val);
             if(headA==headB){
                 return headA;
             }
             headA=headA.next;
             headB=headB.next;
        }
        return null;
    }
}