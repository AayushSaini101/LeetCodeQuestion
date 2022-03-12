/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
 
    
    public Node copyRandomList(Node head) {
        Node ans = null;
        Node last = null;
		
        HashMap<Node,Node> map = new HashMap<>();
        
        Node temp =head;
        while(head!=null) {
            Node temp1=new Node(head.val);
            map.put(head,temp1);
            if(ans==null) {
                ans=temp1;
                last=temp1;
            } else {
                last.next=temp1;
                last=temp1;
            }
            head=head.next;
            
        }
        
        last=ans;
        while(last!=null) {
            Node rd = map.get(temp.random);
            // System.out.println(temp.random+" "+rd);
            last.random=rd;
            last=last.next;
            temp=temp.next;
            
        }
        return ans;
    }
}