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
    public TreeNode insertIntoBST(TreeNode root, int val) {
         //if the root is null means not BST 
        if(root==null){
           root=new TreeNode(val);
            return root;
        }
        if(val>root.val){
            root.right=insertIntoBST(root.right,val);
        }
        else{
            root.left=insertIntoBST(root.left,val);
        }
        return root;
    }
}