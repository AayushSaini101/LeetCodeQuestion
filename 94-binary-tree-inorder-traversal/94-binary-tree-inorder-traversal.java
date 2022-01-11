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
    public List<Integer> inorderTraversal(TreeNode root) {
        //Inorder transversal using the morris transversal
        TreeNode reference=root;
        //Programming to interface binding
        List<Integer>inorder=new ArrayList<>();
        
        while(reference!=null){
            //Left part is not present
            if(reference.left==null){
                inorder.add(reference.val);
                reference=reference.right;
            }
            else{
                //Find the rightest node from the left subtree 
                TreeNode temp=reference.left;
                
                while(temp.right!=null&&temp.right!=reference){
                       temp=temp.right;
                }
                
                if(temp.right!=reference){
                   
                    temp.right=reference;
                    
                    reference=reference.left;
                }
                else{
                   temp.right=null;
                   inorder.add(reference.val);
                   reference=reference.right;
                }
                
            }
        }
        return inorder;
    }
}