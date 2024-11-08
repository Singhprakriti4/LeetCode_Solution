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
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer,TreeNode> m=new HashMap<>();
        return find(root,k,m);

    }
    public boolean find(TreeNode root,int k,Map<Integer,TreeNode> m){
        if(root==null){
            return false;
        }
        if(m.containsKey(k-root.val)){
            return true;
        }
        else{
            m.put(root.val,root);
        }
        return (find(root.left,k,m) || find(root.right,k,m));
    }

}