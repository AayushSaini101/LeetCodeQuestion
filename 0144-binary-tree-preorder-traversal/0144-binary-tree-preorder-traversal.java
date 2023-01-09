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
    public void answer(TreeNode root,List<Integer>answer){
        
        if(root == null)return ;
        
        answer.add(root.val);
        
        answer(root.left,answer);
        
        answer(root.right,answer);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
     
        List<Integer> answer = new ArrayList<>();
        
        Stack<TreeNode>st=new Stack<>();
        
        st.add(root);
        
        while(st.size()!=0){
            
            TreeNode remove = st.pop();
            
            if(remove == null) break;
            
            answer.add(remove.val);
            
            if(remove.right!=null){
                
                st.add(remove.right);
            }
            
            if(remove.left!=null){
                
                st.add(remove.left);
            }
        }
        
        return answer;
        
   
    }
}