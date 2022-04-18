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
    private int element=0;
    private int level=0;
    
    public void find(TreeNode root,int k){
        if(root==null||k<0){
            return;
        }
        find(root.left,k);
                --level;
        // System.out.println(level);
        if(level==0){
            element=root.val;
        }

       
        find(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
          this.level=k;
        find(root,k);
      
        
        return element;
    }
}