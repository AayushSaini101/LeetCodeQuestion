/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // We have to check whether the tree is identical or not 

        if(q==null&&p==null)return true;
      
        Queue<TreeNode> Q = new LinkedList<>();
        
        Q.add(p);
        
        Q.add(q);
        
        
        while(Q.size()!=0){
            
            
            TreeNode first = Q.remove();
            
            TreeNode second = Q.remove();
            
            if(first == null && second != null)return false;
            
            else
                if(first != null && second == null)return false;
            
            if(first.val != second.val)return false;
            
            if(first.val == Integer.MAX_VALUE || second.val == Integer.MAX_VALUE)continue;
            
           
            Q.add(first.left!=null?first.left:new TreeNode(Integer.MAX_VALUE));
            
            Q.add(second.left!=null?second.left:new TreeNode(Integer.MAX_VALUE));
            
            Q.add(first.right!=null?first.right:new TreeNode(Integer.MAX_VALUE));
            
            Q.add(second.right!=null?second.right:new TreeNode(Integer.MAX_VALUE));
            
            
        }
        
        return true;
        
    }
}