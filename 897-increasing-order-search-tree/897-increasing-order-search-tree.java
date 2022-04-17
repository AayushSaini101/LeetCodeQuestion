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
    TreeNode answer=null;
    TreeNode helper=null;
    public TreeNode rearrange(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode left=increasingBST(root.left);
         {
          //  System.out.println(root.val);
            if(answer==null){
        
                answer=new TreeNode(root.val);
                helper=answer;
            }
            else{
                answer.right=new TreeNode(root.val);
                answer=answer.right;
            }
        }
        TreeNode right=increasingBST(root.right);
       
        return root;
    }
    public TreeNode increasingBST(TreeNode root) {
       rearrange(root);
        
        return this.helper;
    }
}