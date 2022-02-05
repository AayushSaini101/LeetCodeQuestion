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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer>values=new ArrayList<>();
        for(int i=0;i<lists.length;++i){
            ListNode temp=lists[i];
            while(temp!=null){
                values.add(temp.val);
                temp=temp.next;
            }
            
        }
        Collections.sort(values);
        ArrayList<Integer>ans=new ArrayList<>(values);
        ListNode anss=null;
        ListNode temp=anss;
        for(int elements:ans){
            if(anss==null){
                anss=new ListNode(elements);
                temp=anss;
                
            }
            else{
                temp.next=new ListNode(elements);
                temp=temp.next;
            }
        }
        return anss;
        
    }
}