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
    public int sum=0;
    public void sum(TreeNode root,String msg){
        if(root==null){
            return; 
        }
        //use the number 
        msg+=root.val;
        sum(root.left,msg);
        sum(root.right,msg);
        //System.out.println(msg);
        if(root.left==null&&root.right==null)
        sum+=Integer.parseInt(msg.toString(),2);
        msg=msg.substring(0,msg.length()-1);
    }
    public int sumRootToLeaf(TreeNode root) {
        if(root==null){
            return 0;
        }
        //Find the height of the tree and use the bitwise operator to the mask the value
         sum(root,"");
         return sum;
    }
}