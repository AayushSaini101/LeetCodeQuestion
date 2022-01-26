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
    public void find(TreeNode root,List<Integer>lst){
        if(root==null){
            return;
        }
        find(root.left,lst);
        lst.add(root.val);
        find(root.right,lst);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>lst=new ArrayList<>();
    find(root1,lst);
        find(root2,lst);
        Collections.sort(lst);
        return lst;
    }
}