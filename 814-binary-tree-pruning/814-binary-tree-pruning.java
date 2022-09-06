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
    public boolean check(TreeNode root){
        
        if(root==null)return false;
        
        if(root.val==1)return true;
        
        return check(root.left)||check(root.right);
    }
    public TreeNode pruneTree(TreeNode root) {
        
        if(root==null){
            
            return null;
        }
        
        int checkBoth=0;
        
        if(!check(root.left)){
            
            root.left=null;
            
            checkBoth++;
            
        }
        if(!check(root.right)){
            
            root.right=null;
            
            checkBoth++;
        }
        
        if(checkBoth==2&&root.val==0){
            
            root=null;
            
        
        }
        
        if(root!=null)
        pruneTree(root.left);
        
        if(root!=null)
        pruneTree(root.right);
        
        return root;
        
    }
}