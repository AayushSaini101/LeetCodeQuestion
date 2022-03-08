/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
     //Checkwether the cycle contains a cycle or not 
    //Cycle means the node is connected to the previous node that is alraedy connected 
        HashSet<ListNode>H=new HashSet<>();
        
        while(head!=null){
            if(H.contains(head)){
                return true;
            }
            H.add(head);
            head=head.next;
        }
        return false;
    }
}