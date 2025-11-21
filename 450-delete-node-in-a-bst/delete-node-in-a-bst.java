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

       if(root==null){
        return null;
       } 

       if(root.val>key){
        root.left=deleteNode(root.left,key);
        return root;
       }
       if(root.val<key){
        root.right=deleteNode(root.right,key);
        return root;
       }
       //we are at the target node


       if(root.left==null && root.right==null){
        //leaf node
        return null;
       }

       if(root.left==null){
        return root.right;
       }
       if(root.right==null){
        return root.left;
       }

       //both side is available
       TreeNode lefthigh=root.left;

       while(lefthigh.right!=null){
        lefthigh=lefthigh.right;
       }

       root.val=lefthigh.val;
       root.left=deleteNode(root.left,root.val);
       return root;

    }
}