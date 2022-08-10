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
    static TreeNode create(int left,int right,int nums[]){
     int start=left;
     TreeNode ans=null;
     int end=right;
     if(start<=end){
        int mid=(start+end)/2;
         ans=new TreeNode(nums[mid]);
         ans.left=create(start,mid-1,nums);
         ans.right=create(mid+1,end,nums);
     }
        return ans;
        
        
    }
    public TreeNode sortedArrayToBST(int[] nums) {
     TreeNode ans=create(0,nums.length-1,nums);
    return ans;
    }
}