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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        Queue<TreeNode>Q=new LinkedList<>();
        
        
        if(depth==1){
            
          TreeNode newRoot=new TreeNode(val);
            
          newRoot.left=root;
            
          return newRoot;
            
        }
        
        
        Q.add(root);
        
        int countDepth=0;
        
        int check=0;
        
        while(Q.size()!=0){
            
            int size=Q.size();
            
             ++countDepth;
            
        
            if(countDepth==depth-1){
                
                check=1;
                
            }
            
            for(int i=0;i<size;++i){
                
                TreeNode remove=Q.remove();
                
                if(remove==null)continue;
                
                if(check==1){
                    
                    TreeNode left1=remove.left;
                    
                    TreeNode right1=remove.right;
                    
                    remove.left=new TreeNode(val);
                    
                    remove.right=new TreeNode(val);
                    
                    remove.left.left=left1;
                   
                
                    remove.right.right=right1;
                    
                    
                    Q.add(remove.left.left);
                    
                    Q.add(remove.right.right);
                    
                  
                    
                
                }
                else{
                
                  Q.add(remove.left);
                
                  Q.add(remove.right);
                
                }
                
                
            
            }
            
             
                    check=0;
        }
        
        return  root;
    }
}