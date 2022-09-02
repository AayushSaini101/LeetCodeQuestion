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
    public List<Double> averageOfLevels(TreeNode root) {
        
        Queue<TreeNode>Q=new LinkedList<>();
        
        Q.add(root);
        
        List<Double>average=new ArrayList<>();
        
        while(Q.size()!=0){
            
            int size=Q.size();
            
            long answer=0;
            
            for(int i=0;i<size;++i){
             
                TreeNode remove=Q.remove();
                
                answer+=remove.val;
                
                if(remove.left!=null)Q.add(remove.left);
                if(remove.right!=null)Q.add(remove.right);
            }
            
            average.add((double)answer/size);
            
            
        }
        return average;
    }
}