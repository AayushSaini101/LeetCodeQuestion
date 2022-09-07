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
    
    public StringBuffer answer=new StringBuffer("");
    
    public void generate(TreeNode root){
        
        if(root==null)return;
        
           answer.append(root.val);
        
        if(root.left!=null&&root.right!=null){
        
             answer.append("(");
        
             generate(root.left);
            
             answer.append(")");
                
             answer.append("(");
            
             generate(root.right);
        
             answer.append(")");
               
      }
      else
    
      if(root.left==null&&root.right!=null){
          
         answer.append("(");
        
         answer.append(")");
          
         answer.append("(");
          
         generate(root.right);
          
         answer.append(")");
          
      }
        
      else
      if(root.left!=null&&root.right==null){
          
          answer.append("(");
          
          generate(root.left);
          
          answer.append(")");
      }
        
        
        
        
    }
    public String tree2str(TreeNode root) {
        
        generate(root);
        
        return this.answer.toString();
    }
}