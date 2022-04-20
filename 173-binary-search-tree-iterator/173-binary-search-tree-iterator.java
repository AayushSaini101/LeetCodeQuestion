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
class BSTIterator {
    int index=-1;
    List<Integer>lst=new ArrayList<>();
    
    public void inorder(TreeNode root,List<Integer>Lst){
        if(root==null){
            return ;
        }
        inorder(root.left,lst);
        lst.add(root.val);
        inorder(root.right,lst);
    }
    public BSTIterator(TreeNode root) {
        inorder(root,this.lst);
        
    }
    
    public int next() {
        ++index;
        return lst.get(index);
    }
    
    public boolean hasNext() {
        if(index==lst.size()-1){
            return false;
        }
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */