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
    public int answer=0;
    public int find(TreeNode root){
        if(root==null)return 0;
        int left=find(root.left);
        int right=find(root.right);
        
        answer+=Math.abs(left)+Math.abs(right);
        
        return left+right+root.val-1;
    }
    public int distributeCoins(TreeNode root) {
        
        find(root);
        
        return answer;
    }
}