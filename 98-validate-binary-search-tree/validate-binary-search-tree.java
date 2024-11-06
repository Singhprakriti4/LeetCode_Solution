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
    List<Integer> arr=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
       return inorder(root);
    }
 public boolean inorder(TreeNode root){
        if(root==null){
            return true;
        }
        boolean leftans=inorder(root.left);
        arr.add(root.val);
        if(arr.size()>1){
            if(arr.get(arr.size()-1) <= arr.get(arr.size()-2))
             return false;
        }
        boolean rightans=inorder(root.right);
        return leftans && rightans;
    }
    
}