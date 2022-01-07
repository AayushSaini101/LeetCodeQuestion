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

    
    private int size=0;
    
    private List<Integer>ls=new ArrayList<>();
    
    private int getsize(ListNode head){
        if(head==null){
            return 0;
        }
        this.ls.add(head.val);
        return 1+getsize(head.next);
        
    }
    public Solution(ListNode head) {
        
     
     this.size=getsize(head);   
        
    }
    
    public int getRandom() {
    
    int random=(int)(Math.random()*this.size);
    
     return ls.get(random);   
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */