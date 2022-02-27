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
   
     class Pair
    {
        TreeNode val;
        int pos;
        Pair(TreeNode val,int pos)
        {
            this.val=val;
            this.pos=pos;
        }
    }
    public int widthOfBinaryTree(TreeNode root) 
    {
        if(root==null)
            return 0;
        int ans=1;
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(root,0));
        int k=0;
        while(!queue.isEmpty())
        {
            int sz=queue.size();
            for(int i=1;i<=sz;++i)
            {
                Pair tmp=queue.remove();
                TreeNode val=tmp.val;
                int pos=tmp.pos;
                if(i==1)
                    k=pos-1;
                ans=Math.max(ans,Math.abs(pos-k));
                if(val.left!=null)
                    queue.add(new Pair(val.left,pos*2+1));
                if(val.right!=null)
                    queue.add(new Pair(val.right,pos*2+2));
            }
        }
        return ans;
    }
}