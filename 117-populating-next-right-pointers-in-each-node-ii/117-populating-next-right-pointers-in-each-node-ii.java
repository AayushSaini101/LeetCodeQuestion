/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        Queue<Node>Q=new LinkedList<>();
        
        Node answer=root;
        
        Q.add(root);
        
        while(Q.size()!=0){
            
            int size=Q.size();
            
            Node old=answer;
            
            for(int i=0;i<size;++i){
             
                //Removing all the nodes from the level 
                Node remove=Q.remove();
                
                if(remove.left!=null){
                    
                    Q.add(remove.left);
                }
                if(remove.right!=null){
                    Q.add(remove.right);
                }
               
                if(i==0){
                    
                    old=remove;
                }
                else{
                    old.next=remove;
                    
                    old=old.next;
                }
            }
        }
        return answer;
    }
}