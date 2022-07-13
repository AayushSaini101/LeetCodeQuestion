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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode>Q=new LinkedList<>();
        List<List<Integer>>L=new ArrayList<>();
        Q.add(root);
        while(Q.size()>=1){
        int count=Q.size();
            
              List<Integer>Temp=new ArrayList<>();
            for(int i=1;i<=count;++i){
                TreeNode temp=Q.peek();
                Q.remove();
                if(temp!=null){
                Temp.add(temp.val);
                
                if(temp.left!=null){
                    Q.add(temp.left);
                }
                if(temp.right!=null){
                    Q.add(temp.right);
                }
                }
            }
            if(Temp.size()!=0)
            L.add(Temp);
            
        }
        return L;
        
    }
}