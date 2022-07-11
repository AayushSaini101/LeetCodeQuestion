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

    
    public List<Integer> rightSideView(TreeNode root) {
    Queue<TreeNode>Q=new LinkedList<>();
    Q.add(root);
    List<Integer>L=new ArrayList<>();
   while(Q.size()!=0){
       int size=Q.size();
       for(int i=1;i<=size;++i){
           TreeNode temp=Q.poll();
           if(i==size&&temp!=null){
               L.add(temp.val);
           }
           if(temp!=null&&temp.left!=null){
               Q.add(temp.left);
           }
           if(temp!=null&&temp.right!=null){
               Q.add(temp.right);
           }
       }
   }
        return L;
    }
}