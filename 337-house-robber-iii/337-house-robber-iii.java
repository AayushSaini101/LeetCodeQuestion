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
    HashMap<TreeNode,Integer>H=new HashMap<>();
    public int rob(TreeNode root) {
        
        if(root==null){
            return 0;
        }
        if(H.containsKey(root)){
            return H.get(root);
        }
        int leftmax=0;
        int rightmax=0;
        if(root.left!=null){
            leftmax=rob(root.left.left)+rob(root.left.right);
        }
        if(root.right!=null){
            rightmax=rob(root.right.left)+rob(root.right.right);
        }
        int ans= Math.max(root.val+leftmax+rightmax,rob(root.left)+rob(root.right));
        H.put(root,ans);
        return ans;
    }
}