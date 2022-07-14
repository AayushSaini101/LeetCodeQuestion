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
    int index=0;
    
    TreeNode build(int preorder[],int inorder[],int left,int right){
        if(left>right){
            return null;
        }
        int value=preorder[index++];
        TreeNode root=new TreeNode(value);
        int index=search(inorder,left,right,value);
        root.left=build(preorder,inorder,left,index-1);
        root.right=build(preorder,inorder,index+1,right);
        return root;
        
          
    }
    int search(int a[],int left,int right,int value){
        int i=0;
        for(i=left;i<=right;++i){
            if(a[i]==value){return i;}
        }
        return i;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      
       TreeNode root= build(preorder,inorder,0,preorder.length-1);
        return root;
    }
}