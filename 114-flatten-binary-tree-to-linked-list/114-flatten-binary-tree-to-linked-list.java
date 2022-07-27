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
    public void flatten(TreeNode root) {
        
        Stack<TreeNode>St=new Stack<>();
        
        St.add(root);
        
        while(St.size()!=0){
            
            TreeNode remove=St.pop();
            
            if(remove==null){
                
                continue;
            }
            
            if(remove.right!=null){
                
                St.add(remove.right);
            }
            if(remove.left!=null){
                
                St.add(remove.left);
            }
            
            if(St.size()!=0){
                
                remove.right=St.peek();
                
                remove.left=null;
            }
            
        }
        
    }
}