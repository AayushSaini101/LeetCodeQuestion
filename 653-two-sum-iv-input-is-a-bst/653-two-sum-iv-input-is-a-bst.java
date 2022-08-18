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
    public boolean find(TreeNode root,int sum,HashSet<Integer>H){
        
        if(root==null){
            
            return false;
        }
        
      
        if(H.contains((sum-root.val))){
            
         //   System.out.println(sum+" "+root.val);
            
            return true;
        }
        
        boolean answer=false;
        
        if(root.right!=null&&root.right.val>sum){
            
            H.add(root.val);
            
            answer|=find(root.left,sum,H);
            
            answer|=find(root.right,sum,H);
        }
        else{
            
            H.add(root.val);
            
            answer|=find(root.left,sum,H);
            
            answer|=find(root.right,sum,H);
        }
        
        return answer;
    }
    public boolean findTarget(TreeNode root, int k) {
        
        boolean find=find(root,k,new HashSet());
        
        return find;
    }
}