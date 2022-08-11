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
  
    
    public void inorder(TreeNode root,List<Integer>lst){
        
        if(root==null){
            
            return ;
        }
        
        inorder(root.left,lst);
        lst.add(root.val);
        inorder(root.right,lst);
    }
    public boolean isValidBST(TreeNode root) {
        
      List<Integer>lst=new ArrayList<>();
        
      inorder(root,lst);
        
      for(int i=1;i<lst.size();++i){
          
          if(!(lst.get(i-1)<lst.get(i))){
              return false;
          }
      }
    
             return true;
    }
}