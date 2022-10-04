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
    public TreeNode original=null;
    
    public boolean findPath(TreeNode root,int targetSum){
        
     
        if(root==null){
            
            return false;
        }
        
        else
            if(root.left==null&&root.right==null&&root.val==targetSum)return true;
        
        
        boolean answer=false;
        
        answer|=findPath(root.left,targetSum-root.val);
        
        answer|=findPath(root.right,targetSum-root.val);
        
        return answer;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        //The main key point remember here the path should be the the leaf 
        
         if(root==null)return false;
        
         original=root;
        
         
        
        return findPath(root,targetSum);
    }
}