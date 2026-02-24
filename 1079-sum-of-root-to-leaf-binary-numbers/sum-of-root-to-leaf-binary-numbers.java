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
    int ans;
    public int sumRootToLeaf(TreeNode root) {
        ans=0;
        sum(root, new StringBuilder());
        return ans;
    }
    public void sum(TreeNode root, StringBuilder sb){

        if(root.left==null && root.right==null){
            sb.append(root.val);
            String str=sb.toString();
            // System.out.println(str+":");
            int val=Integer.parseInt(str, 2);
            // System.out.println(val);
            ans+=val;
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        sb.append(root.val);
        if(root.left!=null){
        sum(root.left, sb);
        }
        if(root.right!=null){
        sum(root.right, sb);
        }
        sb.deleteCharAt(sb.length()-1);
    }
}