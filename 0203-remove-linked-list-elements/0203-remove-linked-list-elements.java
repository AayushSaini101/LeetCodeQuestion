class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        return deleteNode(head, val);
   
}

    private ListNode deleteNode(ListNode head, int val){
        if(head == null){
            return head;
        }
        
        while(head!=null&&head.val==val){
            
            head=head.next;
        }
        if(head==null)return head;
        
        ListNode temp = head;
        ListNode prev = null;
      
        while (temp != null) {
            if(temp.val == val){
                prev.next = temp.next;
                temp = temp.next;
                
                continue;
            }
            
            prev = temp;
            temp = temp.next;
        }
        if (temp == null){
            return head;
        }

      
        return head;

    }
}