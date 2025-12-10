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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q==null&&p==null)return true;
        if(q==null && p!=null)return false;
        if(p==null && q!=null)return false;
        boolean data;
        if(q.val==p.val){
            data = true;
        }
        else{
            data = false;
        }

        boolean left = isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right,q.right);

        return data && left && right;
    }
}