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
    
    public void findPath(TreeNode root,int sum,List<Integer>helper,List<List<Integer>>answer,boolean flag){
       
        if(root==null)return ;
        
    
      
        helper.add(root.val);
        
        //We have two option either move to the at least one node 
        
        if(root.left==null&&root.right==null){
            
            if(root.val==sum){
             
                answer.add(new ArrayList<>(helper));
                
            }
        
           
        
        }
        else{
            
             findPath(root.left,sum-root.val,helper,answer,flag);
        
             findPath(root.right,sum-root.val,helper,answer,flag);
        
        
             
        }
        
        helper.remove(helper.size()-1);
            
        
      
        
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>>paths = new ArrayList<>();
        
        
        findPath(root,targetSum,new ArrayList<>(),paths,false);
        
        return paths;
    }
}