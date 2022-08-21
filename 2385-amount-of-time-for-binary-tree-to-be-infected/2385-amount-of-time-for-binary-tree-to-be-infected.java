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
    
    public void transverse(TreeNode root,HashMap<Integer,List<Integer>>map){
        
        if(root==null){
            
            return;
        }
        
        if(root.left!=null){
        map.computeIfAbsent(root.val,k->new ArrayList<>()).add(root.left.val);
        map.computeIfAbsent(root.left.val,k->new ArrayList<>()).add(root.val);
            
        }
        if(root.right!=null){
        map.computeIfAbsent(root.val,k->new ArrayList<>()).add(root.right.val);
        map.computeIfAbsent(root.right.val,k->new ArrayList<>()).add(root.val);
        
        }
        transverse(root.left,map);
        transverse(root.right,map);
    }
    public int count(int node,int parent,HashMap<Integer,List<Integer>>H){
        
        
        int max=0;
        
        for(int elements:H.get(node)){
            
            if(elements==parent)continue;
            
            max=Math.max(max,1+count(elements,node,H));
        
            
            
        }
        return max;
        
   
    }
    public int amountOfTime(TreeNode root, int start) {
        
        HashMap<Integer,List<Integer>>H=new HashMap<>();
        
        
        transverse(root,H);
        
        if(H.containsKey(start)==false)return 0;
        
        int count=count(start,-1,H);
        
       
        return count;
        
        
    }
}