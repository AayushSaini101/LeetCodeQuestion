/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
       
        Queue<Node>Q=new LinkedList<>();
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
         if(root==null){
            return ans;
        }
        Q.add(root);
        while(Q.size()!=0){
        
          List<Integer>L=new ArrayList<>();
          int size=Q.size();
         for(int i=0;i<size;++i){
             Node temp=Q.remove();
             if(temp!=null){
             L.add(temp.val);
             for(Node values:temp.children){
                Q.add(values);
             }
             }
         }
            ans.add(L);
            
            
        }
        return ans;
    
        
    }
}