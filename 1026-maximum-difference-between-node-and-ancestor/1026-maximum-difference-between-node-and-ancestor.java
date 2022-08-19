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
    
    public int min=0;
    
    public void findMinimum(TreeNode root,int value){
        
        if(root==null){
            
            return ;
        }
        
        if(value==-1){
            
            value=root.val;
        }
        else{
                 
            min=Math.max(min,Math.abs(value-root.val));
        }
            findMinimum(root.left,value);
            
            findMinimum(root.right,value);
        
        
        
    }
    public void find(TreeNode root){
        
        if(root==null)return;
        
        findMinimum(root,-1);
        
        find(root.left);
        
        find(root.right);
    } 
    public int maxAncestorDiff(TreeNode root) {
     
        
        find(root);
        
        return min;
        
        
    }
}