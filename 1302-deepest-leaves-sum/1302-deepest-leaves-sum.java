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
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        
        return 1+Math.max(height(root.left),height(root.right));
    }
    public int deepestLeavesSum(TreeNode root) {
     
        int height=height(root);
        
        Queue<TreeNode>Q=new LinkedList<>();
        
        Q.add(root);
        
        int sum=0;
        
        
        while(Q.size()!=0){
            
           int size=Q.size();
            
            --height;
            
           for(int i=0;i<size;++i){
               
               TreeNode remove=Q.remove();
               
               if(remove!=null){
                   
                   if(height==0){
                       
                       sum+=remove.val;
                   }
                   
                   Q.add(remove.left);
                   
                   Q.add(remove.right);
               }
           }
               
        }
        return sum;
    }
}