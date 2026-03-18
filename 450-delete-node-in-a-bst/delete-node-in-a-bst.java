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
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }
    public TreeNode delete(TreeNode root, int key){
        if(root==null){
            return null;
        }
        if(key<root.val){
           root.left=delete (root.left, key);
        //    return root;
        }
        else if(key>root.val){
            root.right= delete(root.right, key);
            // return root;
        }
        else{
            if(root.left==null && root.right==null){
                return null;
            }
            TreeNode replace;
            if(root.left!=null){
                replace=find(root.left, true);
                int v=root.val;
                root.val=replace.val;
                replace.val=v;
                root.left=delete(root.left, key);
            }
            else{
                replace=find(root.right, false);
                int v=root.val;
                root.val=replace.val;
                replace.val=v;
                root.right=delete(root.right, key);
            }
        }
        return root;
    }
    public TreeNode find(TreeNode root, boolean max){
        if(root.left==null && root.right==null){
            return root;
        }
        if(max){
            if(root.right==null){
                return root;
            }
            return find(root.right, max);
        }
        if(root.left==null){
            return root;
        }
        return find(root.left, max);
    }
}