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
    public int countNodes(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return 0;
        }
        int count=0;
        q.add(root);
        while(!q.isEmpty()){
           TreeNode n=q.poll();
           count++;
           if(n.left!=null){
            q.add(n.left);
           }
           if(n.right!=null){
            q.add(n.right);
           }
        }
        return count;
    }
}