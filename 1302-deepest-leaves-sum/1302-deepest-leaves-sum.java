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
    public void find(TreeNode root,int depth,HashMap<Integer,Integer>H){
        if(root==null){
            return;
        }
        H.put(depth,H.getOrDefault(depth,0)+root.val);
        find(root.left,depth+1,H);
        find(root.right,depth+1,H);
    }
    public int deepestLeavesSum(TreeNode root) {
        
        HashMap<Integer,Integer>H=new HashMap<>();
        
        find(root,0,H);
        
        int sum=0;
        
        int max=0;
        
        for(int elements:H.keySet()){
            
            if(elements>max){
                max=elements;
                sum=H.get(elements);
            }
        }
        
        return sum;
    }
}