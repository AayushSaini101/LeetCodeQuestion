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
         
        TreeNode reference=root;
        
        List<Integer>lst=new ArrayList<>();
        
        while(reference!=null){
            
            if(reference.left==null){
              
                lst.add(reference.val);
                
                reference=reference.right;
                
            }
            else{
                
                //Move to the left side of the node 
                
                TreeNode temp=reference.left;
            
                //This is also formation of the preprocessing the values 
                
                while(temp!=null&&temp.right!=null&&temp.right!=reference){
                    
                    temp=temp.right;
                }
                
                if(temp.right!=reference){
                 
                    temp.right=reference;
                    
                    reference=reference.left;
                
                }
                else{
                    temp.right=null;
                    lst.add(reference.val);
                    reference=reference.right;
                   
                    
                    
                }
                
            }
        }
        
        return lst;
    }
}